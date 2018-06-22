package com.server.handler.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jmimemagic.Magic;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.server.common.CbhsResUtils;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.ResourceService;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsResource;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class ResourceServiceImp implements ResourceService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Value("${server.url}")
	private String url;

	@Override
	public CbhsResource resourceUpload(MultipartFile file, HttpServletRequest httpServletRequest) throws Exception {
		CbhsResource resource = new CbhsResource();
		if (!file.isEmpty()) {
			String contentType = file.getContentType();
			String oldfileName = file.getOriginalFilename();
			String prefix = oldfileName.substring(oldfileName.lastIndexOf(".") + 1);
			long fileSize = file.getSize();
			resource.setContentType(contentType);
			resource.setOldFileName(oldfileName);
			resource.setPrefix(prefix);
			resource.setFileSize(fileSize);
			String fileName = UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String myPath = "resources/upload/" + fileName;
			String filePath = this.getClass().getResource("/").getPath() + myPath;
			try {
				File ff = new File(filePath);
				FileUtils.copyInputStreamToFile(file.getInputStream(), ff);
				resource.setFilePath(ff.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			long time = System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			resource.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			resource.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			resource.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
			resource.setOpTime(time);
			resource.setUrl(myPath);
			resource = queryFactory.saveOrUpdate(resource);
		}
		return resource;
	}

	@Override
	public void down(Integer resourceOid, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
		Preconditions.checkArgument(resourceOid > 0, "文件ID不能为空!");
		CbhsResource resource = queryFactory.findOne(CbhsResource.class, resourceOid);
		Preconditions.checkArgument(resource != null, "文件不存在!");
		File downLoadFile = new File(resource.getFilePath());
		Preconditions.checkArgument(downLoadFile.exists(), "文件不存在!");
		response.reset();
		String mime = Magic.getMagicMatch(downLoadFile, false).getMimeType();
		response.setContentType(mime);
		response.setContentLength(resource.getFileSize().intValue());
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(downLoadFile.getName().getBytes(), "UTF-8"));
		FileInputStream fis = new FileInputStream(downLoadFile);
		byte buff[] = new byte[1024];
		int len = 0;
		OutputStream os = response.getOutputStream();
		while ((len = fis.read(buff)) > 0) {
			os.write(buff, 0, len);
		}
		os.close();
		fis.close();
	}

	@Override
	public JSONObject errorLogupload(MultipartFile file, HttpServletRequest httpServletRequest) throws Exception {
		if (!file.isEmpty()) {
			String oldfileName = file.getOriginalFilename();
			String prefix = oldfileName.substring(oldfileName.lastIndexOf(".") + 1);
			if (!prefix.equals("log")) {
				throw new ServiceException(new ExceptionResponse(-1, "后缀名必须为.log!"));
			}
			String myPath = "errorlog/" + new DateTime().toString("yyyy-MM-dd") + "/" + oldfileName;
			String filePath = this.getClass().getResource("/").getPath() + myPath;
			try {
				File ff = new File(filePath);
				FileUtils.copyInputStreamToFile(file.getInputStream(), ff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return CbhsResUtils.suc();
	}

}

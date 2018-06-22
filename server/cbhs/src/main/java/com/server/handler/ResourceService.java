package com.server.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsResource;

public interface ResourceService {
	public CbhsResource resourceUpload(MultipartFile request, HttpServletRequest httpServletRequest) throws Exception;

	public void down(Integer resourceOid, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception;

	public JSONObject errorLogupload(MultipartFile request, HttpServletRequest httpServletRequest) throws Exception;
}

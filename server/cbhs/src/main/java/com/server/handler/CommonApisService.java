package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.common.RequestLogin;
import com.server.pojo.url.common.ResponseLogin;
import com.server.pojo.url.common.RequestExit;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestRegAdmin;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestRegUser;
import com.server.pojo.bean.CbhsUser;
import com.server.pojo.url.common.RequestGetUser;
import com.server.pojo.url.common.ResponseGetUser;
import com.server.pojo.url.common.RequestModifyPwd;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsUser;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestUploadAvatar;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestDelUser;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsRole;
import com.server.pojo.bean.CbhsRole;
import com.server.pojo.bean.CbhsRole;
import com.server.pojo.bean.CbhsRole;
import com.server.pojo.url.common.RequestRoleDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestRoleFetch;
import com.server.pojo.url.common.ResponseRoleFetch;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.url.common.RequestDeptDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.common.RequestDeptFetch;
import com.server.pojo.url.common.ResponseDeptFetch;
import com.server.pojo.url.common.RequestJPushRegID;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsVersion;
import com.server.pojo.bean.CbhsVersion;
import com.server.pojo.url.common.RequestVersionFetch;
import com.server.pojo.url.common.ResponseVersionFetch;
import com.server.pojo.bean.CbhsVersion;
import com.server.pojo.bean.CbhsVersion;

public interface CommonApisService {

	public ResponseLogin login(RequestLogin request) throws Exception;

	public JSONObject exit(RequestExit request) throws Exception;

	public JSONObject regAdmin(RequestRegAdmin request) throws Exception;

	public CbhsUser regUser(RequestRegUser request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGetUser getUser(RequestGetUser request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject modifyPwd(RequestModifyPwd request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject updateUser(CbhsUser request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject uploadAvatar(RequestUploadAvatar request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject delUser(RequestDelUser request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsRole roleAdd(CbhsRole request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsRole roleUpdate(CbhsRole request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject roleDel(RequestRoleDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseRoleFetch roleFetch(RequestRoleFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDept deptAdd(CbhsDept request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDept deptUpdate(CbhsDept request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject deptDel(RequestDeptDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseDeptFetch deptFetch(RequestDeptFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject jPushRegID(RequestJPushRegID request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsVersion versionAdd(CbhsVersion request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseVersionFetch versionFetch(RequestVersionFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsVersion versionUpdate(CbhsVersion request, HttpServletRequest httpServletRequest) throws Exception;

}

package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.url.base.RequestProjectFetch;
import com.server.pojo.url.base.ResponseProjectFetch;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.url.base.RequestCailiaoDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestCailiaoFetch;
import com.server.pojo.url.base.ResponseCailiaoFetch;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.url.base.RequestCailiaoKemuDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestCailiaoKemuFetch;
import com.server.pojo.url.base.ResponseCailiaoKemuFetch;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.url.base.RequestFbCompanyDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestFbCompanyFetch;
import com.server.pojo.url.base.ResponseFbCompanyFetch;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.url.base.RequestMachineryTypeDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestMachineryTypeFetch;
import com.server.pojo.url.base.ResponseMachineryTypeFetch;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.url.base.RequestMachineryDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestMachineryFetch;
import com.server.pojo.url.base.ResponseMachineryFetch;
import com.server.pojo.bean.CbhsGlfyRule;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsGlfyRule;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestCbhsGlfyRuleFetch;
import com.server.pojo.bean.CbhsGlfyRule;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.url.base.RequestGzDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestGzFetch;
import com.server.pojo.url.base.ResponseGzFetch;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.url.base.RequestHtDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestHtFetch;
import com.server.pojo.url.base.ResponseHtFetch;
import com.server.pojo.bean.CbhsContacts;
import com.server.pojo.bean.CbhsContacts;
import com.server.pojo.bean.CbhsContacts;
import com.server.pojo.bean.CbhsContacts;
import com.server.pojo.url.base.RequestContactsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.base.RequestContactsFetch;
import com.server.pojo.url.base.ResponseContactsFetch;

public interface BaseApisService {

	public CbhsProject projectAdd(CbhsProject request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsProject projectUpdate(CbhsProject request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseProjectFetch projectFetch(RequestProjectFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsCailiao cailiaoAdd(CbhsCailiao request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsCailiao cailiaoUpdate(CbhsCailiao request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cailiaoDel(RequestCailiaoDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseCailiaoFetch cailiaoFetch(RequestCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cailiaoImport(MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsCailiaoKemu cailiaoKemuAdd(CbhsCailiaoKemu request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsCailiaoKemu cailiaoKemuUpdate(CbhsCailiaoKemu request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cailiaoKemuDel(RequestCailiaoKemuDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseCailiaoKemuFetch cailiaoKemuFetch(RequestCailiaoKemuFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsFbCompany fbCompanyAdd(CbhsFbCompany request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsFbCompany fbCompanyUpdate(CbhsFbCompany request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbCompanyDel(RequestFbCompanyDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbCompanyFetch fbCompanyFetch(RequestFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMachineryType machineryTypeAdd(CbhsMachineryType request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMachineryType machineryTypeUpdate(CbhsMachineryType request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject machineryTypeDel(RequestMachineryTypeDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseMachineryTypeFetch machineryTypeFetch(RequestMachineryTypeFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMachinery machineryAdd(CbhsMachinery request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMachinery machineryUpdate(CbhsMachinery request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject machineryDel(RequestMachineryDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseMachineryFetch machineryFetch(RequestMachineryFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cbhsGlfyRuleAdd(CbhsGlfyRule request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cbhsGlfyRuleUpdate(CbhsGlfyRule request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGlfyRule cbhsGlfyRuleFetch(RequestCbhsGlfyRuleFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGz gzAdd(CbhsGz request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGz gzUpdate(CbhsGz request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject gzDel(RequestGzDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGzFetch gzFetch(RequestGzFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsHt htAdd(CbhsHt request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsHt htUpdate(CbhsHt request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject htDel(RequestHtDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseHtFetch htFetch(RequestHtFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsContacts contactsAdd(CbhsContacts request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsContacts contactsUpdate(CbhsContacts request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject contactsDel(RequestContactsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseContactsFetch contactsFetch(RequestContactsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject contactsImport(MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception;

}

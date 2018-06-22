package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.zytj.RequestZytjFetch;
import com.server.pojo.url.zytj.ResponseZytjFetch;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.url.zytj.RequestZytjDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.zytj.RequestZytjAdd;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.url.zytj.RequestZdgxhsFetch;
import com.server.pojo.url.zytj.ResponseZdgxhsFetch;
import com.server.pojo.bean.CbhsZdgxhs;
import com.server.pojo.bean.CbhsZdgxhs;
import com.server.pojo.url.zytj.RequestZdgxhsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsZdgxhs;
import com.server.pojo.bean.CbhsZdgxhs;

public interface ZytjApisService {

	public ResponseZytjFetch zytjFetch(RequestZytjFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsZytj zytjUpdate(CbhsZytj request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zytjDel(RequestZytjDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsZytj zytjAdd(RequestZytjAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZdgxhsFetch zdgxhsFetch(RequestZdgxhsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsZdgxhs zdgxhsUpdate(CbhsZdgxhs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zdgxhsDel(RequestZdgxhsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsZdgxhs zdgxhsAdd(CbhsZdgxhs request, HttpServletRequest httpServletRequest) throws Exception;

}

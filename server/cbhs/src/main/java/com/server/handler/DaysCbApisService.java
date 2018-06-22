package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.daysCb.RequestJjcbFetch;
import com.server.pojo.url.daysCb.ResponseJjcbFetch;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.url.daysCb.RequestJjcbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestJjcbAdd;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.url.daysCb.RequestGlfyFetch;
import com.server.pojo.url.daysCb.ResponseGlfyFetch;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.url.daysCb.RequestGlfyDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestGlfyAdd;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.url.daysCb.RequestTodayFetch;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.url.daysCb.RequestZyLxygCbFetch;
import com.server.pojo.url.daysCb.ResponseZyLxygCbFetch;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.url.daysCb.RequestZyLxygCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestZyLxygCbAdd;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.url.daysCb.RequestZyJxCbFetch;
import com.server.pojo.url.daysCb.ResponseZyJxCbFetch;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.url.daysCb.RequestZyJxCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestZyJxCbAdd;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.url.daysCb.RequestZyQtCbFetch;
import com.server.pojo.url.daysCb.ResponseZyQtCbFetch;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.url.daysCb.RequestZyQtCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestZyQtCbAdd;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbFetch;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbFetch;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.RequestFbGclTjCbFetch;
import com.server.pojo.url.daysCb.ResponseFbGclTjCbFetch;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.url.daysCb.RequestFbGclTjCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestFbGclTjCbAdd;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.url.daysCb.RequestFbLjxmCbFetch;
import com.server.pojo.url.daysCb.ResponseFbLjxmCbFetch;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.url.daysCb.RequestFbLjxmCbDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestFbLjxmCbAdd;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.url.daysCb.RequestFbJgUpdate;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysCb.RequestFbJgAdd;
import com.alibaba.fastjson.JSONObject;

public interface DaysCbApisService {

	public ResponseJjcbFetch jjcbFetch(RequestJjcbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysJjcb jjcbUpdate(CbhsDaysJjcb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject jjcbDel(RequestJjcbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysJjcb jjcbAdd(RequestJjcbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGlfyFetch glfyFetch(RequestGlfyFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysGlfyYs glfyUpdate(CbhsDaysGlfyYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject glfyDel(RequestGlfyDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysGlfyYs glfyAdd(RequestGlfyAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysGlfyYs todayFetch(RequestTodayFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyLxygCbFetch zyLxygCbFetch(RequestZyLxygCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyLxygCb zyLxygCbUpdate(CbhsDaysZyLxygCb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyLxygCbDel(RequestZyLxygCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyLxygCb zyLxygCbAdd(RequestZyLxygCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyJxCbFetch zyJxCbFetch(RequestZyJxCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyJxCb zyJxCbUpdate(CbhsDaysZyJxCb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyJxCbDel(RequestZyJxCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyJxCb zyJxCbAdd(RequestZyJxCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyQtCbFetch zyQtCbFetch(RequestZyQtCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyQtCb zyQtCbUpdate(CbhsDaysZyQtCb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyQtCbDel(RequestZyQtCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyQtCb zyQtCbAdd(RequestZyQtCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyCailiaoCbFetch zyCailiaoCbFetch(RequestZyCailiaoCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysZyCailiaoCb zyCailiaoCbUpdate(CbhsDaysZyCailiaoCb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyCailiaoCbDel(RequestZyCailiaoCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyCailiaoCbAdd zyCailiaoCbAdd(RequestZyCailiaoCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbGclTjCbFetch fbGclTjCbFetch(RequestFbGclTjCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysFbGclTj fbGclTjCbUpdate(CbhsDaysFbGclTj request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbGclTjCbDel(RequestFbGclTjCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysFbGclTj fbGclTjCbAdd(RequestFbGclTjCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbLjxmCbFetch fbLjxmCbFetch(RequestFbLjxmCbFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysFbLjxmCb fbLjxmCbUpdate(CbhsDaysFbLjxmCb request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbLjxmCbDel(RequestFbLjxmCbDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysFbLjxmCb fbLjxmCbAdd(RequestFbLjxmCbAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbJgUpdate(RequestFbJgUpdate request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbJgAdd(RequestFbJgAdd request, HttpServletRequest httpServletRequest) throws Exception;

}

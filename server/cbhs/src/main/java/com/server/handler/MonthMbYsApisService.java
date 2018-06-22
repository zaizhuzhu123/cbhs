package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.monthMbYs.RequestJjcbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseJjcbYsFetch;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.url.monthMbYs.RequestJjcbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.url.monthMbYs.RequestGlfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseGlfyYsFetch;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.url.monthMbYs.RequestGlfyYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyCailiaoCbYs;
import com.server.pojo.bean.CbhsMonthZyCailiaoCbYs;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyLxygCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyJxCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyQtfyYsFetch;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbLjxmCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.url.monthMbYs.RequestFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.RequestFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbCailiaoCbYs;
import com.server.pojo.bean.CbhsMonthFbCailiaoCbYs;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsTotalFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsTotalFetch;

public interface MonthMbYsApisService {

	public ResponseJjcbYsFetch jjcbYsFetch(RequestJjcbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthJjcbYs jjcbYsUpdate(CbhsMonthJjcbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject jjcbYsDel(RequestJjcbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthJjcbYs jjcbYsAdd(CbhsMonthJjcbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGlfyYsFetch glfyYsFetch(RequestGlfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthGlfyYs glfyYsUpdate(CbhsMonthGlfyYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject glfyYsDel(RequestGlfyYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthGlfyYs glfyYsAdd(CbhsMonthGlfyYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyCailiaoCbYsFetch zyCailiaoCbYsFetch(RequestZyCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyCailiaoCbYs zyCailiaoCbYsUpdate(CbhsMonthZyCailiaoCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyCailiaoCbYsDel(RequestZyCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyCailiaoCbYsAdd zyCailiaoCbYsAdd(RequestZyCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyCailiaoCbYsCailiaoFetch zyCailiaoCbYsCailiaoFetch(RequestZyCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyLxygCbYsFetch zyLxygCbYsFetch(RequestZyLxygCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyLxygCbYs zyLxygCbYsUpdate(CbhsMonthZyLxygCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyLxygCbYsDel(RequestZyLxygCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyLxygCbYs zyLxygCbYsAdd(CbhsMonthZyLxygCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyJxCbYsFetch zyJxCbYsFetch(RequestZyJxCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyJxCbYs zyJxCbYsUpdate(CbhsMonthZyJxCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyJxCbYsDel(RequestZyJxCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyJxCbYs zyJxCbYsAdd(CbhsMonthZyJxCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyQtfyYsFetch zyQtfyYsFetch(RequestZyQtfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyQtfyYs zyQtfyYsUpdate(CbhsMonthZyQtfyYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject zyQtfyYsDel(RequestZyQtfyYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthZyQtfyYs zyQtfyYsAdd(CbhsMonthZyQtfyYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbLjxmCbYsFetch fbLjxmCbYsFetch(RequestFbLjxmCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthFbLjxmCbYs fbLjxmCbYsUpdate(CbhsMonthFbLjxmCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbLjxmCbYsDel(RequestFbLjxmCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthFbLjxmCbYs fbLjxmCbYsAdd(CbhsMonthFbLjxmCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbGcCbYsFetch fbGcCbYsFetch(RequestFbGcCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthFbGcCbYs fbGcCbYsUpdate(CbhsMonthFbGcCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbGcCbYsDel(RequestFbGcCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthFbGcCbYs fbGcCbYsAdd(CbhsMonthFbGcCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbGcGlobalXmFetch fbGcGlobalXmFetch(RequestFbGcGlobalXmFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbGcFbCompanyFetch fbGcFbCompanyFetch(RequestFbGcFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbCailiaoCbYsFetch fbCailiaoCbYsFetch(RequestFbCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsMonthFbCailiaoCbYs fbCailiaoCbYsUpdate(CbhsMonthFbCailiaoCbYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject fbCailiaoCbYsDel(RequestFbCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbCailiaoCbYsAdd fbCailiaoCbYsAdd(RequestFbCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbCailiaoCbYsCailiaoFetch fbCailiaoCbYsCailiaoFetch(RequestFbCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseMbYsFetch mbYsFetch(RequestMbYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseMbYsTotalFetch mbYsTotalFetch(RequestMbYsTotalFetch request, HttpServletRequest httpServletRequest) throws Exception;

}

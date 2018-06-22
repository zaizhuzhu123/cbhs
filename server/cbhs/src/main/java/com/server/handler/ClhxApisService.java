package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.clhx.RequestZyGclFetch;
import com.server.pojo.url.clhx.ResponseZyGclFetch;
import com.server.pojo.url.clhx.RequestZyClhxFetch;
import com.server.pojo.url.clhx.ResponseZyClhxFetch;
import com.server.pojo.url.clhx.RequestFbGclFetch;
import com.server.pojo.url.clhx.ResponseFbGclFetch;
import com.server.pojo.url.clhx.RequestFbClhxFetch;
import com.server.pojo.url.clhx.ResponseFbClhxFetch;

public interface ClhxApisService {

	public ResponseZyGclFetch zyGclFetch(RequestZyGclFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZyClhxFetch zyClhxFetch(RequestZyClhxFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbGclFetch fbGclFetch(RequestFbGclFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbClhxFetch fbClhxFetch(RequestFbClhxFetch request, HttpServletRequest httpServletRequest) throws Exception;

}

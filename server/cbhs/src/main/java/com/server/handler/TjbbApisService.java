package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.tjbb.RequestCbsrbb;
import com.server.pojo.url.tjbb.ResponseCbsrbb;
import com.server.pojo.url.tjbb.RequestZybb;
import com.server.pojo.url.tjbb.ResponseZybb;
import com.server.pojo.url.tjbb.RequestDaysDetails;
import com.server.pojo.bean.uiDaysCbDetailTj;
import com.server.pojo.url.tjbb.RequestGrandTotal;
import com.server.pojo.bean.uiGrandTotalTj;

public interface TjbbApisService {

	public ResponseCbsrbb cbsrbb(RequestCbsrbb request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZybb zybb(RequestZybb request, HttpServletRequest httpServletRequest) throws Exception;

	public uiDaysCbDetailTj daysDetails(RequestDaysDetails request, HttpServletRequest httpServletRequest) throws Exception;

	public uiGrandTotalTj grandTotal(RequestGrandTotal request, HttpServletRequest httpServletRequest) throws Exception;

}

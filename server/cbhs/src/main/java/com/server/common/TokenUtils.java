package com.server.common;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.server.util.DES;

public class TokenUtils {
	/**
	 * 根据传入的T类型生成token Json
	 * 
	 * @param <T>
	 * @param ser
	 * @return
	 */
	public static String createToken(CbhsTokenInfos ser) {
		ser.setTimestamp(System.currentTimeMillis());
		String jsonStr = null;
		String token = null;
		if (ser != null) {
			jsonStr = JSON.toJSONString(ser);
			token = DES.encrypt(jsonStr);
		}
		return token;
	}

	/**
	 * 根据传入的T类型生成token Json
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param ser
	 * @return
	 * @throws Exception
	 */
	public static CbhsTokenInfos ObjectByToken(String token) throws Exception {
		String jsonStr = null;
		if (token != null) {
			jsonStr = DES.decrypt(token);
			return JSON.parseObject(jsonStr, CbhsTokenInfos.class);
		}
		return null;
	}

	/**
	 * 从HttpServletRequest中得到TokenInfo对象 @Title: getTokenInfo @Description: TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param httpServletRequest
	 * @param @return 设定文件
	 * @return YqtTokenInfos 返回类型 @throws
	 * @throws Exception
	 */
	public static CbhsTokenInfos getTokenInfo(HttpServletRequest httpServletRequest) throws Exception {
		String token = getTokenByHttpServletRequest(httpServletRequest);
		return ObjectByToken(token);
	}

	/**
	 * 从HttpServletRequest获取header中的token @Title: getTokenByHttpServletRequest @Description: TODO(这里用一句话描述这个方法的作用) @param @param httpServletRequest @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String getTokenByHttpServletRequest(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader("token");
		return token;
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// try {
		// System.out.println(DES.decrypt("FD39F76A66B45B0E9DB5D1E25CDD50A5A79D3D19DD6254D379000778F7DE8F1F85E747750E49621DF55E601E6C8A4DC73E9C0BB6FE96F7900B4761C2AF30FAF08FD031092DF24EEDB86847E6217FED37C58DFAEDC6020B3EDEC5BF42D3E4885B"));
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}

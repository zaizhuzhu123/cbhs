package com.server.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * java后台极光推送方式二：使用Java SDK
 */
public class JiguangPush {
	private static final Logger log = LoggerFactory.getLogger(JiguangPush.class);
	private static String masterSecret = "4bfcef1e8bee92bd5bac3ef9";
	private static String appKey = "1d9d62636bf53d2fe116e000";

	public static final int type_exam = 1; // 审核推送
	public static final int type_upgrade = 2; // 版本推送

	public PushResult jiguangPush(List<String> registrationIds, int type, String title, String alert, String message, String extKey, String extValue) {
		return push(registrationIds, type, title, alert, message, extKey, extValue);
	}

	/**
	 * 生成极光推送对象PushPayload（采用java SDK）
	 * 
	 * @param alias
	 * @param alert
	 * @return PushPayload
	 */
	public static PushPayload buildPushObject_android(List<String> registrationIds, int type, String tile, String alert, String message, String typeKey, String typeValue) {
		if (registrationIds != null && registrationIds.size() > 0) {
			return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.registrationId(registrationIds)).setNotification(Notification.newBuilder().addPlatformNotification(AndroidNotification.newBuilder().setTitle(tile).setAlert(alert).addExtra("type", type).addExtra(typeKey, typeValue).build()).build()).setMessage(Message.content(message))
					.setOptions(Options.newBuilder().setApnsProduction(true)// true-推送生产环境
							.setTimeToLive(86400)// 消息在JPush服务器的失效时间（测试使用参数）
							.build())
					.build();
		} else {
			return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.all()).setNotification(Notification.newBuilder().addPlatformNotification(AndroidNotification.newBuilder().setTitle(tile).setAlert(alert).addExtra("type", type).addExtra(typeKey, typeValue).build()).build()).setMessage(Message.content(message))
					.setOptions(Options.newBuilder().setApnsProduction(true)// true-推送生产环境
							.setTimeToLive(86400)// 消息在JPush服务器的失效时间（测试使用参数）
							.build())
					.build();
		}

	}

	/**
	 * 极光推送方法(采用java SDK)
	 * 
	 * @param alias
	 * @param alert
	 * @return PushResult
	 */
	public static PushResult push(List<String> registrationIds, int type, String title, String alert, String message, String extKey, String extValue) {
		ClientConfig clientConfig = ClientConfig.getInstance();
		clientConfig.setConnectionTimeout(20 * 1000);
		clientConfig.setSocketTimeout(40 * 1000);
		clientConfig.setReadTimeout(60 * 1000);
		clientConfig.setMaxRetryTimes(10);
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
		// "examOid"
		PushPayload payload = buildPushObject_android(registrationIds, type, title, alert, message, extKey, extValue);
		try {
			return jpushClient.sendPush(payload);
		} catch (APIConnectionException e) {
			log.error("Connection error. Should retry later. ", e);
			return null;
		} catch (APIRequestException e) {
			log.error("Error response from JPush server. Should review and fix it. ", e);
			log.info("HTTP Status: " + e.getStatus());
			log.info("Error Code: " + e.getErrorCode());
			log.info("Error Message: " + e.getErrorMessage());
			log.info("Msg ID: " + e.getMsgId());
			return null;
		}
	}

	public static void main(String[] args) {
		new JiguangPush().push(null, 1, "1", "1", "1", "1", "1");
	}
}
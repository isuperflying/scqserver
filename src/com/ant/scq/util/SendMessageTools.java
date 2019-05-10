package com.ant.scq.util;

import com.ant.scq.config.AppConfig;
import com.ant.scq.lib.MESSAGEXsend;

public class SendMessageTools {

	private static SendMessageTools sendUtil;

	public static SendMessageTools getInstance() {
		if (sendUtil == null) {
			sendUtil = new SendMessageTools();
		}
		return sendUtil;
	}

	public boolean sendMessage(String phoneNumber, String security) {
		boolean flag = true;
		try {
			AppConfig config = ConfigLoader
					.load(ConfigLoader.ConfigType.Message);
			MESSAGEXsend submail = new MESSAGEXsend(config);
			submail.addTo(phoneNumber);
			submail.setProject("C5yuZ3");
			submail.addVar("code", security);
			submail.xsend();
		} catch (Exception e1) {
			flag = false;
			e1.printStackTrace();
		}
		System.out.println("短信验证码发送是否成功---" + flag);
		return flag;
	}
}

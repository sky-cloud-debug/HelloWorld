package com.water.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.water.util.Config;
import com.water.util.HttpUtil;

public class test {

	// url中20150822之后的部分
	// 参数详述请参考http://www.qingmayun.com/document.html
	private static String accountSid = Config.ACCOUNT_SID;

	private static String emailTemplateId = "22760089";
	private static String to = "18764881202";
	private static String param = "聊吧";

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		String url = Config.BASE_URL;
		String body = "accountSid=" + accountSid
				+ "&smsContent=【水肥一体化节水灌溉】出水口1号，灌溉面积：13亩，需灌溉量：312.156立方米。出水口2号，灌溉面积：10亩，需灌溉量：240.12立方米。出水口3号，灌溉面积：10亩，需灌溉量：240.12立方米。出水口4号，灌溉面积：11.5亩，需灌溉量：276.13800000000003立方米。设置灌溉量，请登录http://202.194.131.174:8080/water/water/login2?status=autoControl&to=" + to
				+ HttpUtil.createCommonParam();
		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}

}

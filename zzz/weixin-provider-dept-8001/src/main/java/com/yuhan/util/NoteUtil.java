package com.yuhan.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Random;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;



public class NoteUtil {

private final static int APP_ID = 1400247636;

private final static String APP_KEY = "da887e330bd0abb7719d32adc431fc34";
public static String test(String tel) {
	int x = new Random().nextInt(1000000);
	String sendCode = String.valueOf(x);
	SmsSingleSender ssender = new SmsSingleSender(APP_ID, APP_KEY);
	try {
	    SmsSingleSenderResult result = ssender.send(0, "86", tel,
	        "【煜韩科技】"+sendCode+"为您的煜宠商城注册验证码，请于5分钟内填写。如非本人操作，请忽略本短信。", "", "");
	    System.out.println(result);
	} catch (HTTPException e) {
	    // HTTP响应码错误	
	    e.printStackTrace();
	} catch (JSONException e) {
	    // json解析错误
	    e.printStackTrace();
	} catch (IOException e) {
	    // 网络IO错误
		e.printStackTrace();
	}
	return sendCode;
}


	public static String httpRequestToString(String url,
											 Map params) {
		String result = null;
		try {
			InputStream is = httpRequestToStream(url,  params);
			BufferedReader in = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			result = buffer.toString();
		} catch (Exception e) {
			return null;
		}
		return result;
	}

	private static InputStream httpRequestToStream(String url,
												   Map params) {
		InputStream is = null;
		try {
			String parameters = "";
			boolean hasParams = false;
			for(Object key : params.keySet()){
				String value = URLEncoder.encode((String) params.get(key), "UTF-8");
				parameters += key +"="+ value +"&";
				hasParams = true;
			}
			if(hasParams){
				parameters = parameters.substring(0, parameters.length()-1);
			}

			url += "?"+ parameters;

			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("contentType", "utf-8");
			conn.setConnectTimeout(50000);
			conn.setReadTimeout(50000);
			conn.setDoInput(true);
			//设置请求方式，默认为GET
			conn.setRequestMethod("GET");

			is = conn.getInputStream();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}
}

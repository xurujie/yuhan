package com.yuhan.test;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class WXPayExample {
/*
    public static void main(String[] args) throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "abc");
        data.put("out_trade_no", "2016090910595900000012");
        data.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://49.234.133.200:8080/yuhan/l");
        data.put("trade_type", "JSAPI");
        data.put("openid", "o8cP-4ztKM-JhkwAZQiXH0eQv05w");
data.put("sign",MD5Tool.getSign(config.getAppID(),"abc",config.getMchID(),"5K8264ILTKCH16CQ2502SI8ZNMTM67VS","http://49.234.133.200:8080/yuhan/l","o8cP-4ztKM-JhkwAZQiXH0eQv05w","2016090910595900000012"
,"123.12.12.123","1","JSAPI"));
        String sign = data.get("sign");
        System.out.println(sign);
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
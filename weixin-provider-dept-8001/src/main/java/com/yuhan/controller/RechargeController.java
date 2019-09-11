package com.yuhan.controller;

import com.yuhan.util.MapConversionXml;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RechargeController {

    //订单返回
    @RequestMapping(value = "/qlydweixinotify.do")
    public String integralDetails(HttpServletRequest req, HttpServletResponse rep) {
        try {
            InputStream inStream = req.getInputStream();
            int _buffer_size = 1024;
            if (inStream != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] tempBytes = new byte[_buffer_size];
                int count = -1;
                while ((count = inStream.read(tempBytes, 0, _buffer_size)) != -1) {
                    outStream.write(tempBytes, 0, count);
                }
                tempBytes = null;
                outStream.flush();
                //将流转换成字符串
                String result = new String(outStream.toByteArray(), "UTF-8");
                //将字符串解析成XML
               /* Document doc = DocumentHelper.parseText(result);*/
                //将XML格式转化成MAP格式数据
                Map<String, String> resultMap = MapConversionXml.xmlToMap(result);
                for(Map.Entry<String,String> entry:resultMap.entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
            }
            //通知微信支付系统接收到信息
            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //如果失败返回错误，微信会再次发送支付信息
        return "fail";
    }


}

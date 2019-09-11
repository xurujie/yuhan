package com.yuhan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yuhan.entities.UserInformation;
import com.yuhan.entities.Vip;
import com.yuhan.service.VipService;
import com.yuhan.test.MyConfig;
import com.yuhan.util.DateUtil;
import com.yuhan.util.ListUtil;
import com.yuhan.util.NoteUtil;
import feign.Param;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class VipController {
    StringBuffer sb;
    @Autowired
    VipService vipService;



    @RequestMapping(value = "/Vip/chongZhi", method = RequestMethod.POST)
    public String balongsLists(HttpServletRequest req){
        UserInformation userInformation = (UserInformation)req.getSession().getAttribute("user");
        String name= req.getParameter("name");
        String id_number = req.getParameter("id_number");
        String tel = req.getParameter("tel");
        String sum = req.getParameter("sum");
        Vip vip = new Vip();
        vip.setUser_id(userInformation.getId());
        vip.setName(name);
        vip.setId_number(id_number);
        vip.setTel(tel);
        vip.setFirst_time(Timestamp.valueOf(DateUtil.formate(new Date(),"yyyy-MM-dd HH:mm:ss")));
        vip.setEnd_time(DateUtil.formateAddMonth(new Date(),Integer.parseInt(sum)));
        int i=vipService.addVip(vip);
        sb = new StringBuffer();
        sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"state\":\"");
if(i==1){
    sb.append(1);
}else {
    sb.append(0);
}
        sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }

    @RequestMapping(value = "/testtest", method = RequestMethod.GET)
    public void getOpenId(HttpServletRequest request,
                          HttpServletResponse response, String code) throws UnsupportedEncodingException {
      /*  response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");*/
        Map params = new HashMap();
        params.put("secret", "yuhanweixinxiaochengxukaifazhexu");
        params.put("appid", "wx7c5b20758cd2fea5");
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        String result = NoteUtil.httpRequestToString(
                "https://api.weixin.qq.com/sns/oauth2/access_token", params);
        JSONObject jsonObject = JSONObject.parseObject(result);

        String openid = jsonObject.get("openid").toString();
        System.out.println("得到的openid为:"+openid);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        VipController vipController = new VipController();
        vipController.getOpenId(null,null,"1231231");
    }
}

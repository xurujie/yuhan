package com.yuhan.controller;


import com.yuhan.entities.Integral;
import com.yuhan.entities.Merchandise;
import com.yuhan.entities.MerchandiseShow;
import com.yuhan.service.IntegralService;
import com.yuhan.service.MerchandiseService;
import com.yuhan.service.MerchandiseShowService;
import com.yuhan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
public class IntegralController {
    StringBuffer sb ;
    @Autowired
    IntegralService integralService;
    @Autowired
    MerchandiseShowService merchandiseShowService;
    @Autowired
    MerchandiseService merchandiseService;

    //积分换购商品列表
    @RequestMapping(value = "/Integral/list", method = RequestMethod.POST)
    public String integralList(HttpServletRequest req) {
       String pageNumber= req.getParameter("pageNumber");
       String pageSize=req.getParameter("pageSize");
        sb = new StringBuffer();
        sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"Integral\": [");
     List<Integral>  integrals = integralService.findBy(Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
     for(Integral integral : integrals){
        MerchandiseShow merchandiseShow =  merchandiseShowService.findById(integral.getMerchandise_id());
        sb.append("{"+integral+",");
        sb.append("\"merchandise\":"+merchandiseShow+"},");

     }sb=sb.deleteCharAt(sb.length()-1);
        sb.append("]},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }



    //积分换购商品详情页
    @RequestMapping(value = "/Integral/Details", method = RequestMethod.POST)
    public String integralDetails(HttpServletRequest req) {
        String s =  req.getParameter("merchandiseId");
        Integral integral = integralService.findByMerchandiseId(Integer.parseInt(s));
        sb = new StringBuffer();
        sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"integral\":{");
        sb.append(integral+",");
        sb.append(merchandiseService.findById(integral.getMerchandise_id()));
        sb.append("}},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }
}

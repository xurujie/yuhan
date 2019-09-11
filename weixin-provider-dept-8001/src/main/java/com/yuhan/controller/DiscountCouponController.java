package com.yuhan.controller;


import com.yuhan.entities.DiscountCoupon;
import com.yuhan.entities.Integral;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.DiscountCouponService;
import com.yuhan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class DiscountCouponController {

    StringBuffer sb;

    @Autowired
    DiscountCouponService discountCouponService;

    //个人优惠券列表
    @RequestMapping(value = "/User/DiscountCoupon", method = RequestMethod.POST)
    public String integralDetails(HttpServletRequest req) {
        String s = req.getParameter("discountCoupon");
        UserInformation userInformation = (UserInformation)req.getSession().getAttribute("user");
        sb = new StringBuffer();

        sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"integral\":{");
discountCouponService.addDiscountCoupon(userInformation.getId(),Integer.parseInt(s));

        sb.append("}},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }

    //优惠券类别列表 1代表新人优惠
    @RequestMapping(value = "/newUser/DiscountCoupon", method = RequestMethod.POST)
    public String newDiscountCouponList(HttpServletRequest req) {
        String type = req.getParameter("type");
        sb = new StringBuffer();
        UserInformation userInformation = (UserInformation)req.getSession().getAttribute("user");
        if(userInformation==null){
          sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{\"status\":\"0\"},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd   HH:mm:ss")+"\"}");
            return sb.toString();
        }


        sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"discountCoupons\":{");
        List<DiscountCoupon> discountCoupons = discountCouponService.newDiscountCouponList(type);
        for (DiscountCoupon discountCoupon :discountCoupons){
            sb.append(discountCoupon+",");
        }
        sb =sb.delete(sb.length()-1,sb.length());
        sb.append("");
        sb.append("}},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }

}

package com.yuhan.controller;



import com.yuhan.entities.Integral;
import com.yuhan.entities.ShoppingTrolley;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.MerchandiseShowService;
import com.yuhan.service.ShoppingTrolleyService;
import com.yuhan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class ShoppingTrolleyController {
    StringBuffer sb;
    @Autowired
    ShoppingTrolleyService shoppingTrolleyService;
    @Autowired
    MerchandiseShowService merchandiseShowService;


    //购物车列表
    @RequestMapping(value = "/ShoppingTrolley/list", method = RequestMethod.POST)
    public String shoppingTrolleyList(HttpServletRequest req){
        sb = new StringBuffer();
       UserInformation userInformation = (UserInformation)req.getSession().getAttribute("user");
        if(userInformation==null){
            sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{\"status\":\"0\"},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd   HH:mm:ss")+"\"}");
            return sb.toString();
        }
        sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{");
        sb.append("\"merchandiseShow\":[");
        List<ShoppingTrolley>  shoppingTrolleys=shoppingTrolleyService.findByUserId(userInformation.getId());
        for(ShoppingTrolley shoppingTrolley :shoppingTrolleys){

            sb.append("{\"merchandise\":");
           sb.append(merchandiseShowService.findById(shoppingTrolley.getMerchandise_id()));
           sb.append(",\"sum\":\""+shoppingTrolley.getMerchandise_sum()+"\"},");
        }
        sb =sb.delete(sb.length()-1,sb.length());
        sb.append("]},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }



    //添加商品到购物车
    @RequestMapping(value = "/ShoppingTrolley/add", method = RequestMethod.POST)
    public String addShoppingTrolley(HttpServletRequest req){
        sb = new StringBuffer();
        String merchandiseId =req.getParameter("merchandiseId");
        String merchandiseSum = req.getParameter("merchandiseSum");
        UserInformation user = (UserInformation) req.getSession().getAttribute("user");
        if(user==null){
            sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{\"status\":\"0\"},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd   HH:mm:ss")+"\"}");
            return sb.toString();
        }
        ShoppingTrolley shoppingTrolley = new ShoppingTrolley();
        shoppingTrolley.setUser_id(user.getId());
        shoppingTrolley.setMerchandise_id(Integer.parseInt(merchandiseId));
        shoppingTrolley.setMerchandise_sum(Integer.parseInt(merchandiseSum));
      int i =  shoppingTrolleyService.addShoppingTrolley(shoppingTrolley);
      if(i==1){
        sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"state\":\""+i+"\"");
        sb.append("},\"sign\":\"2019-08-25 10:10:10\"}");}
        return sb.toString();
    }


    //购物车删除商品
    @RequestMapping(value = "/ShoppingTrolley/delete", method = RequestMethod.POST)
    public String deleteShoppingTrolley(HttpServletRequest req){
        sb = new StringBuffer();
        String merchandiseId =req.getParameter("merchandiseId");
        UserInformation user = (UserInformation) req.getSession().getAttribute("user");
        if(user==null){
            sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{\"status\":\"0\"},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd   HH:mm:ss")+"\"}");
            return sb.toString();
        }
        int i =  shoppingTrolleyService.deleteShoppingTrolley(user.getId(),Integer.parseInt(merchandiseId));
        if(i==1){
            sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"state\":\""+i+"\"");
            sb.append("},\"sign\":\"2019-08-25 10:10:10\"}");}
        return sb.toString();
    }


    //购物车修改商品
    @RequestMapping(value = "/ShoppingTrolley/update", method = RequestMethod.POST)
    public String updateShoppingTrolley(HttpServletRequest req){
        sb = new StringBuffer();
        String merchandiseId =req.getParameter("merchandiseId");
        String merchandiseSum =req.getParameter("merchandiseSum");
        UserInformation user = (UserInformation) req.getSession().getAttribute("user");
        if(user==null){
            sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{\"status\":\"0\"},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd   HH:mm:ss")+"\"}");
            return sb.toString();
        }
        int i =  shoppingTrolleyService.updateShoppingTrolley(user.getId(),Integer.parseInt(merchandiseId),Integer.parseInt(merchandiseSum));
        if(i==1){
            sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"state\":\""+i+"\"");
            sb.append("},\"sign\":\"2019-08-25 10:10:10\"}");}
        return sb.toString();
    }

}

package com.yuhan.controller;


import com.yuhan.entities.SignIn;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.SignInService;
import com.yuhan.service.UserInformationService;
import com.yuhan.util.DateUtil;
import com.yuhan.util.SignInUtil;
import org.apache.ibatis.annotations.Case;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@RestController
public class SignInController {

    StringBuffer sb;

        @Autowired
    UserInformationService userInformationService;
        @Autowired
    SignInService signInService;

    //积分签到页面
    @RequestMapping(value = "/User/SignIn", method = RequestMethod.POST)
    public String balongsList(HttpServletRequest req) throws ParseException {
        /*UserInformation user =   (UserInformation)req.getSession().getAttribute("user");
        int userId =user.getId();*/
        sb = new StringBuffer();
        sb.append("{\"result\":\"2001\",\"msg\":\"Success\",\"data\":{");
            SignIn signIn  = signInService.findByUserId(100001);
        String data = signIn.getSign_time().toString().substring(0,19);
        //判断是否在一周之内
        if(!DateUtil.isSameDate(data ,DateUtil.formate(new Date(),"yyyy-MM-dd   HH:mm:ss"))){
        if(DateUtil.numberOfDaysDifference(signIn.getSign_time(),new Date())==1l) {
            //与上周日相差没有超过一天
         signIn=  SignInUtil.signInAddPart(signIn);
         int i = Integer.parseInt(signIn.getIntegral());
         i++;
        }else {
            //与上周日相差超过一天走这个
           signIn=  SignInUtil.signInAdd(signIn);
        }

        signInService.updateDay(signIn);
        }
        int i = Integer.parseInt(signIn.getIntegral());
        if(i<3){
            i++;
        }else {
            i=i+3;
        }
switch (DateUtil.DateDay()){
    case  1:
        if(signIn.getMonday().equals("0")){
            sb.append("\"count\":\""+i+"\",");
        }else {
            sb.append("\"countNext\":\""+i+"\",");
        }
        break;
    case  2:
        if(signIn.getTuesday().equals("0")){
            sb.append("\"count\":\""+i+"\",");
        }else {
            sb.append("\"countNext\":\""+i+"\",");
        }
        break;
    case  3:
        if(signIn.getWednesday().equals("0")){
            sb.append("\"count\":\""+i+"\",");
        }else {
            sb.append("\"countNext\":\""+i+"\",");
        }
        break;
        case  4:
            if(signIn.getThursday().equals("0")){
                sb.append("\"count\":\""+i+"\",");
            }else {
                sb.append("\"countNext\":\""+i+"\",");
            }
        break;
        case  5:
            if(signIn.getFriday().equals("0")){
                sb.append("\"count\":\""+i+"\",");
            }else {
                sb.append("\"countNext\":\""+i+"\",");
            }
        break;
    case  6:
        if(signIn.getSaturday().equals("0")){
            sb.append("\"count\":\""+i+"\",");
        }else {
            sb.append("\"countNext\":\""+i+"\",");
        }
        break;
    case  7:
        if(signIn.getSunday().equals("0")){
            sb.append("\"count\":\""+i+"\",");
        }else {
            sb.append("\"countNext\":\""+i+"\",");
        }
        break;
}
        sb.append(signIn);
        sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }


    //积分签到页面
    @RequestMapping(value = "/User/SignInAdd", method = RequestMethod.POST)
    public String balongsSignAdd(HttpServletRequest req) throws ParseException {
        /*UserInformation user =   (UserInformation)req.getSession().getAttribute("user");
        int userId =user.getId();*/
        SignIn signIn  = signInService.findByUserId(100001);
        int i = Integer.parseInt(signIn.getIntegral());


        switch (DateUtil.DateDay()){
            case  1:
                if(signIn.getMonday().equals("0")){
                 signIn.setMonday("1");
                }
                break;
            case  2:
                if(signIn.getTuesday().equals("0")){
                    signIn.setTuesday("1");
                }
                break;
            case  3:
                if(signIn.getWednesday().equals("0")){
                    signIn.setWednesday("1");
                }
                break;
            case  4:
                if(signIn.getThursday().equals("0")){
                    signIn.setThursday("1");
                }
                break;
            case  5:
                if(signIn.getFriday().equals("0")){
                    signIn.setFriday("1");
                }
                break;
            case  6:
                if(signIn.getSaturday().equals("0")){
                    signIn.setSaturday("1");
                }
                break;
            case  7:
                if(signIn.getSunday().equals("0")){
                    signIn.setSunday("1");
                }
                break;
        }
        if(i<3){
            i++;
        }else {
            i=i+3;
        }
        signIn.setIntegral(new Integer(i).toString());
        signInService.updateDay(signIn);
        if(i<3){
            i++;
        }else {
            i=i+3;
        }
        UserInformation userInformation = userInformationService.findById(100001);
       int account_integral =  Integer.parseInt(userInformation.getAccount_integral());
       account_integral++;
    userInformation.setAccount_integral(new Integer(account_integral).toString());
        userInformationService.updateUser(userInformation);
        sb = new StringBuffer();
        sb.append("{\"result\":\"2002\",\"msg\":\"Success\",\"data\":{");
        sb.append("\"countNext\":\""+i+"\",");
        sb.append(signIn);
        sb.append("},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }
}

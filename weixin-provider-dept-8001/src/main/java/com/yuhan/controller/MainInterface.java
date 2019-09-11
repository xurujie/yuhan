package com.yuhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.entities.UserInformation;
import com.yuhan.service.UserInformationService;
import com.yuhan.util.DateUtil;
import com.yuhan.util.NoteUtil;

/**
 * 个人中心
 * @author Administrator
 *
 */


@RestController
public class MainInterface {
	StringBuffer sb;
	@Autowired
	private UserInformationService userInformationService;



	//用户主界面
	@RequestMapping(value = "/User/Main", method = RequestMethod.POST)
	public String UserById(HttpServletRequest req,HttpServletResponse rep){
		sb = new StringBuffer();
		sb.append("{\"result\":\"0000\",\"msg\":\"Success\",\"data\":{");
		Object user =req.getSession().getAttribute("user");
		if(user!=null){
			String s =((UserInformation)user).toString();
		 sb.append(s);
		}
		 sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
	}
	
	
	
	 //登陆
	@RequestMapping(value = "/User/Login", method = RequestMethod.POST)
	public String UserLogin(HttpServletRequest req,HttpServletResponse rep){
	String 	username = req.getParameter("userName");
	String passWord = req.getParameter("passWord");
	System.out.println(username);
		sb = new StringBuffer();
		 UserInformation user= (userInformationService.findByUserPassWord(username,  passWord));
		req.getSession().setAttribute("user", user);
		if(user==null){
			sb.append("{\"result\":\"0001\",\"msg\":\"Error\",\"data\":{");
		}else{
			sb.append("{\"result\":\"0001\",\"msg\":\"Success\",\"data\":{");
			sb.append("\"userId\":");
			sb.append("\""+user.getId()+"\"");

			if(user.getYuchong_vip().equals("1")){

            }
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
	}
	
	
	//注册1:获取验证码
	@RequestMapping(value = "/User/enroll1", method = RequestMethod.POST)
	public String Userenroll1(HttpServletRequest req,HttpServletResponse rep){
		String 	tel = req.getParameter("tel");
		sb = new StringBuffer();
		System.out.println(tel);
			sb.append("{\"result\":\"0011\",\"msg\":\"Success\",\"data\":{");
			sb.append("\"status\":\"");
			String captcha = NoteUtil.test(tel);
		System.out.println(captcha);
			if(captcha!=null){
				 req.getSession().setAttribute("captcha", captcha);
				 req.getSession().setAttribute("tel", tel);
				 sb.append("1\"");
			}else {
				sb.append("0\"");
			}

		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();

	}
	
	
	//注册2:验证验证码
	@RequestMapping(value = "/User/enroll2", method = RequestMethod.POST)
	public String Userenroll2(HttpServletRequest req,HttpServletResponse rep){
		String 	captcha = req.getParameter("captcha");
		System.out.println(captcha);

		sb = new StringBuffer();
			sb.append("{\"result\":\"0012\",\"msg\":\"Success\",\"data\":{");
			sb.append("\"status\":\"");
			String  s=  (String) req.getSession().getAttribute("captcha");
		System.out.println(s);
			if(s.equals(captcha)){
				 sb.append("1\"");
			}else {
				sb.append("0\"");
			}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();

	}
	
	
	
	//注册3:添加用户
	@RequestMapping(value = "/User/enroll3", method = RequestMethod.POST)
	public String Userenroll3(HttpServletRequest req,HttpServletResponse rep){
		String passWord =  req.getParameter("passWord");
System.out.println(passWord);
		sb = new StringBuffer();
		sb.append("{\"result\":\"0013\",\"msg\":\"Success\",\"data\":{");
		sb.append("\"status\":\"");
		String tel = (String)req.getSession().getAttribute("tel");
		System.out.println(tel);
		userInformationService.addUser(tel,passWord,tel);
		sb.append("1\"");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
	}
}

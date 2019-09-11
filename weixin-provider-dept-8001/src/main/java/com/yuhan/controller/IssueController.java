package com.yuhan.controller;


import com.yuhan.entities.Issue;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.IssueService;
import com.yuhan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class IssueController {
    StringBuffer sb;
    @Autowired
    IssueService issueService;
    //常见问题
    @RequestMapping(value = "/Issue", method = RequestMethod.POST)
    public String integralDetails(HttpServletRequest req) {
        String type = req.getParameter("type");
        UserInformation userInformation = (UserInformation)req.getSession().getAttribute("user");
        sb = new StringBuffer();
        sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"issues\":");
        List<Issue> byType = issueService.findByType(type);
        sb.append(byType);
        sb.append("},\"sign\":\""+ DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }

}

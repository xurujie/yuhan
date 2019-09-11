package com.yuhan.service.impl;


import com.yuhan.dao.IssueDao;
import com.yuhan.entities.Issue;
import com.yuhan.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl  implements IssueService {

    @Autowired
    IssueDao issueDao;
    @Override
    public List<Issue> findByType(String type) {
        return issueDao.findByType(type);
    }
}

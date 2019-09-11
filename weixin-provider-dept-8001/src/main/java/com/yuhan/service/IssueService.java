package com.yuhan.service;

import com.yuhan.entities.Issue;

import java.util.List;

public interface IssueService {
    public List<Issue> findByType(String type);
}

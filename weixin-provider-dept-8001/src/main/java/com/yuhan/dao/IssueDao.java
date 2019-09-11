package com.yuhan.dao;


import com.yuhan.entities.Issue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IssueDao {
    public List<Issue> findByType(String type);
}

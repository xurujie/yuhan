package com.yuhan.dao;


import com.yuhan.entities.PrefectureImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrefectureImgDao {
    public List<PrefectureImg> findByType(String type);
}

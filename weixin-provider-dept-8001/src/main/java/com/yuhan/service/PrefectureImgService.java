package com.yuhan.service;

import com.yuhan.entities.PrefectureImg;

import java.util.List;

public interface PrefectureImgService {
    public List<PrefectureImg> findByType(String type);
}

package com.yuhan.service.impl;

import com.yuhan.dao.PrefectureImgDao;
import com.yuhan.entities.PrefectureImg;
import com.yuhan.service.PrefectureImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrefectureImgServiceImpl implements PrefectureImgService {

    @Autowired
    PrefectureImgDao prefectureImgDao;

    @Override
    public List<PrefectureImg> findByType(String type)
    {
        return  prefectureImgDao.findByType(type);
    }
}

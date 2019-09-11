package com.yuhan.dao;


import com.yuhan.entities.Integral;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntegralDao {
    public Integral findByMerchandiseId(int merchandiseId);
    public List<Integral> findBy(int first,int end);
}

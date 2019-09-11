package com.yuhan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.yuhan.entities.MerchandiseShow;

@Mapper
public interface MerchandiseShowDao {
public MerchandiseShow findById(int id);
    //根据专区来查询商品列表,只显示前十条
    public List<MerchandiseShow> findByType(@Param("type")String type);
    //根据专区来查询商品列表,从索引开始到结束
    public List<MerchandiseShow>   findByTypePaging(String type,int first,int end);
    //根据专区来查询专区推荐商品
    public List<MerchandiseShow> findByRecommendType(String type,int first,int end);
  public String[]  findByBrand();
  public String[]  findByOrigin();
    public String[]  findByObject();
}

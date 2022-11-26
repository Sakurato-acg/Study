package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand")
    List<Brand> selectAll();

    List<Brand> selectById(@Param("id") Integer id);

    List<Brand> selectByCondition(@Param("status") Integer status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);
//
//    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    public void add(Brand brand);
    public int update(Brand brand);


    public  void deleteById(Integer id);

    public void deleteByIds(@Param("arr") int []arr);
}

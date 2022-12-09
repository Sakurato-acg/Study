package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.Page;

import java.util.List;

public interface BrandService {
    Page<Brand> selectByPage(int start, int count);

    List<Brand> selectAll();

    void add(Brand brand);

    Brand selectById(int id);

    void update(Brand brand);

    void delete(Integer id);

   Page<Brand> selectByCondition(Brand brand,int start,int count);

   void deleteByIds(int []ids);
}

package com.itheima.service.impl;

import com.itheima.Utils.SqlSessionFactoryUtils;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.Page;
import com.itheima.service.BrandService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public Page<Brand> selectByPage(int start, int count) {

        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectByCondition(start, count,null);
        int total = mapper.queryForSingleValueByCondition(null);

        Page<Brand> page = new Page<>();
        page.setTotal(total);
        page.setBrands(brands);
        sqlSession.close();

        return page;
    }


    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Brand> selectAll() {
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     *
     * @param brand
     */
    @Override
    public void add(Brand brand) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }


    /**
     * 根据id查询
     *
     * @return
     */
    @Override
    public Brand selectById(int id) {
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }


    /**
     * 修改
     *
     * @param brand
     */
    @Override
    public void update(Brand brand) {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    @Override
    public void delete(Integer id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Page<Brand> selectByCondition(Brand brand,int start, int count) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        brand.setCompanyName("%"+brand.getCompanyName()+"%");
        brand.setBrandName("%"+brand.getBrandName()+"%");
        List<Brand> brands = mapper.selectByCondition(start, count,brand);
        int total = mapper.queryForSingleValueByCondition(brand);

        Page<Brand> page = new Page<Brand>();
        page.setTotal(total);
        page.setBrands(brands);
        sqlSession.close();

        return page;
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }


}

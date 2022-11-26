package com.itheima.test;

import com.itheima.Utils.BaseMybatis;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest extends BaseMybatis {
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

    @Test
    public void selectAll() throws IOException {

        //3.获取接口代理对象

        List<Brand> brands = mapper.selectAll();

        brands.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void ById() throws IOException {

        //3.获取接口代理对象

        List<Brand> brands = mapper.selectById(2);

        brands.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByCondition() {
        List<Brand> brands = mapper.selectByCondition(
                null,
                "%华为%",
                null);

        brands.forEach(System.out::println);
    }

    @Test
    public void selectByConditionSingle() {
        int status = 0;
        String companyName = "%华为%";
        String brandName = "%华为%";

        Brand nn = new Brand();
//        nn.setCompanyName(companyName);
        List<Brand> brand = mapper.selectByConditionSingle(nn);
        brand.forEach(System.out::println);
    }

    @Test
    public void add() {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的山寨机";
        int ordered = 100;

        Brand brand = new Brand(null, brandName, companyName, ordered, description, status);

        mapper.add(brand);
        System.out.println(brand.getId());
        sqlSession.commit();
    }

    @Test
    public void update() {
        int status = 1;
//        String companyName="波导手机";
//        String brandName="波导";
//        String description="手机中的山寨机";
        int ordered = 400;
        int id = 4;
        Brand brand = new Brand(id, null, null, ordered, null, status);


        int update = mapper.update(brand);
        System.out.println("update = " + update);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteById() {
        int id = 5;
        mapper.deleteById(id);
        commitAndClose();
    }
    @Test
    public void deleteByIds(){
        int []arr={6,7,8};

        mapper.deleteByIds(arr);

        commitAndClose();
    }

}

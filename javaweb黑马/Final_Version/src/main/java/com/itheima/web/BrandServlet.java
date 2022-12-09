package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.Page;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandServlet/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    protected void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据   序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    //6.分页查询
    protected void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("-------------");
//        System.out.println("selectByLimit");

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

//        System.out.println("currentPage = " + currentPage);
//        System.out.println("pageSize = " + pageSize);

        int start = (currentPage - 1) * pageSize;

        Page<Brand> page = brandService.selectByPage(start, pageSize);
        String toJSONString = JSON.toJSONString(page);

//        System.out.println("-------------\n");


        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(toJSONString);
    }


    protected void addBrandSingle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("-------------");
//        System.out.println("addBrand");


        // 获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        // 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
//        System.out.println(brand);
        //2. 调用service 添加
        brandService.add(brand);

//        System.out.println("-------------\n");

        //3. 响应成功标识
        response.getWriter().write("success");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.update(brand);

        response.getWriter().write("success");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        brandService.delete(Integer.valueOf(id));

        response.getWriter().write("success");
    }

    protected void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int start = (currentPage - 1) * pageSize;

        Page<Brand> page = brandService.selectByCondition(brand, start, pageSize);
        String toJSONString = JSON.toJSONString(page);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(toJSONString);
    }


    protected void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String params = request.getReader().readLine();
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }
}

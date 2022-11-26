package com.itheima.test;

import com.itheima.Utils.BaseMybatis;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UseTest extends BaseMybatis {
    @Test
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username="zhangsan";
        String password="123";
        Map map=new HashMap();
        map.put("username",username);
        map.put("password",password);
        User select = mapper.select(map);
        System.out.println("select = " + select);
    }
}

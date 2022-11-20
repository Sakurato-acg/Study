package com.json;

import com.bean.Person;
import com.bean.PersonListType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json {
    //javaBean 和 json 的互转
    @Test
    public void test1() {
        Person aa = new Person(1, "aa");
        Person bb = new Person(2, "bb");
        Gson gson = new Gson();
        //java对象转JSON
        String s = gson.toJson(aa);
        System.out.println(s);
        //JSON转Java
        Person person = gson.fromJson(s, Person.class);
        System.out.println(person);
    }

    //List 和 json 的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "国哥"));
        personList.add(new Person(2, "康师傅"));
        Gson gson = new Gson();
        // 把 List 转换为 json 字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        //JSON转List
        List<Person> list = gson.fromJson(personListJsonString,new TypeToken<List<Person>>(){}.getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);



    }


    // 1.2.3、map 和 json 的互转
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "国哥好帅"));
        personMap.put(2, new Person(2, "康师傅也好帅"));
        Gson gson = new Gson();
        // 把 map 集合转换成为 json 字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        //JSON转Map
        Map<Integer, Person> map = gson.fromJson(personMapJsonString,new TypeToken<HashMap<Integer,Person>>(){}.getType());

        System.out.println(map);
        Person p = map.get(1);
        System.out.println(p);
    }
}

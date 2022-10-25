package com.hspedu.ch15.HomeWork;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001", new User(1, 12, "Jack"));
        userDAO.save("002", new User(2, 32, "King"));
        userDAO.save("003", new User(3, 42, "Mil"));
        List<User> list = userDAO.list();
        System.out.println(list);
    }
}

class User {
    public int id;
    public int age;
    public String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}

class DAO<T> {
    public Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public void delete(String id) {
        map.remove(id);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            list.add(get(key));
        }
        return list;
    }
}

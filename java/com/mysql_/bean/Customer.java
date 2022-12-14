package com.mysql_.bean;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author lpl
 * @Date 2022/7/20 1:44
 * @Version 1.0
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *ORM编程思想
 *一个数据表对应一个java类
 *表中的一条记录对应一个对象
 *表中的一个字段对应一个属性
*/

public class Customer extends ArrayList<Customer> implements Serializable {

    private  int   id   ;
    private String name ;
    private String email;
    private Date   birth;

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}

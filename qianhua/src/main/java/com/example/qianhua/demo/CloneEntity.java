package com.example.qianhua.demo;

import com.example.qianhua.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

//@Data
public class CloneEntity implements Cloneable{
    public CloneEntity(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private String name;
    private Integer age;
    private String sex;
    private List<User> userList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

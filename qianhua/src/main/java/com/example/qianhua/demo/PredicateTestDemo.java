package com.example.qianhua.demo;

import com.example.qianhua.entity.User;

import java.util.function.Predicate;

public class PredicateTestDemo implements Predicate {
    @Override
    public boolean test(Object o) {
        if (o instanceof User){
            if ("zhangsan".equals(((User) o).getName())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        User user = new User("zhangsan",12,"men");
        PredicateTestDemo demo = new PredicateTestDemo();
        if (demo.test(user)){
            System.out.println("满足");
        }else{
            System.out.println("不满足");
        }
    }
}

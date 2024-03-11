package com.example.qianhua.demo;

import com.example.qianhua.entity.User;

public enum signtonEnum {
    INSTANT;

    private User user;

    signtonEnum(){
        this.user = new User();
    }

    public User getSingleton(){
        return user;
    }
}

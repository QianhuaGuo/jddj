package com.example.qianhua.service;

import com.example.qianhua.entity.User;

import java.util.List;
import java.util.function.Function;

public interface TestService {
    List<User> handlerUser(User user, Function<User,List<User>> ff);

    void testAsync() throws InterruptedException;
}

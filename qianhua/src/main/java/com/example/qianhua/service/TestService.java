package com.example.qianhua.service;

import com.example.qianhua.entity.User;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface TestService {
    List<User> handlerUser(User user, Function<User,List<User>> ff);

    void testAsync() throws InterruptedException;

    void test5Async();

    void testLog();

    void handlerTask();

    void resolve(String a, Consumer<String> data, Consumer<Integer> num);
}

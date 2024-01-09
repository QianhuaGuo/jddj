package com.example.qianhua.task;

import com.example.qianhua.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserHandler implements TaskHandler<User>{
    @Override
    public void handler(User user) {
        System.out.println("user处理...");
    }
}

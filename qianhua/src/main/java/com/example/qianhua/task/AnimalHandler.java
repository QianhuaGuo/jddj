package com.example.qianhua.task;

import com.example.qianhua.entity.Animal;
import org.springframework.stereotype.Service;

@Service
public class AnimalHandler implements TaskHandler<Animal>{
    @Override
    public void handler(Animal animal) {
        System.out.println("animal处理...");
    }
}

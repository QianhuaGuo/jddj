package com.example.qianhua.abstractde;

import lombok.Data;

@Data
public abstract class CarAbstract {

    protected Integer wheels;

    protected String type;

    public CarAbstract(Integer wheels,String type){
        this.wheels = wheels;
        this.type = type;
    }

    public abstract void howRun();
}

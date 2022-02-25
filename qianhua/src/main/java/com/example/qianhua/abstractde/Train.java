package com.example.qianhua.abstractde;

import lombok.Data;

@Data
public class Train extends CarAbstract{
    private String carname;

    public Train(Integer wheels, String type) {
        super(wheels, type);
    }

    @Override
    public void howRun() {
        System.out.println("在铁轨上行驶");
    }

}

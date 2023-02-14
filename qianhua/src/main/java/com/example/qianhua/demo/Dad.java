package com.example.qianhua.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class Dad implements Serializable {
    private static final long serialVersionUID = -7153520475610140865L;

    //姓氏
    private String lastName;
}

package com.example.qianhua.entity;

import com.example.qianhua.annotation.NumberCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CheckHh {

    @NotNull(message = "名称不能为空")
    private String name;

    private String nickName;

    @NumberCheck(message = "年龄不能小于0")
    private Integer age;
}

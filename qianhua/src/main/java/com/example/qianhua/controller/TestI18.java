package com.example.qianhua.controller;

import com.baozun.i18n.util.I18nUtils;
import com.example.qianhua.entity.User;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class TestI18 {

    @NotBlank(message = "名称不能为空")
    private String name;

//    @NotNull(message = "user不能为空")
    @NotEmpty(message = "user不能为空")
    @Valid
    private List<Xhs> users;

    @Data
    public static class Xhs{

        @NotBlank(message = "type不能为空")
        private String type;

        @NotNull(message = "age不能为空")
        @Min(value = 2,message = "最小值不能小于2")
        private Integer age;
    }
}

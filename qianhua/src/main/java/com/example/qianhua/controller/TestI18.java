package com.example.qianhua.controller;

import com.baozun.i18n.util.I18nUtils;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestI18 {

    @NotBlank(message = "名称不能为空")
    private String name;
}

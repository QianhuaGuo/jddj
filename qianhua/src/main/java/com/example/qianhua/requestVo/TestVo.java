package com.example.qianhua.requestVo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
public class TestVo extends TestBTO{
//    @NotNull
    private String test;

    private String sql = "delete * from xx";

    @ApiModelProperty(name = "",value = "",required = true,example = "")
    private String xx;

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();

        l.add(null);
        l.add("ss");
        l.add("aa");

        System.out.println(l.size());

        String join = StringUtils.join(l.stream().filter(s -> !StringUtils.isBlank(s)).collect(Collectors.toList()), ";");
        System.out.println(join);
    }
}

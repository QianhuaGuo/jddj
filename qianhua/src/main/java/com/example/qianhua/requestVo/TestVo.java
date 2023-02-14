package com.example.qianhua.requestVo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TestVo extends TestBTO{
//    @NotNull
    private String test;

    private String sql = "delete * from xx";

    private String xx;
}

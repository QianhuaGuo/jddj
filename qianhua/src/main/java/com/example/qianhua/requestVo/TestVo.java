package com.example.qianhua.requestVo;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;
import com.google.common.base.Joiner;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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

        String join1 = Joiner.on("_").skipNulls().join("123", null, UUID.randomUUID());
        System.out.println(join1);

        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        List<String> l2 = new ArrayList<>();
        l2.add("c");
        l2.add("d");
        l2.add("e");
        l2.retainAll(l1);
        log.info(JSONObject.toJSONString(l2));


        System.out.println("version:1");
        List<String> l = new ArrayList<>();

        l.add(null);
        l.add("ss");
        l.add("aa");

        System.out.println(l.size());

        String join = StringUtils.join(l.stream().filter(s -> !StringUtils.isBlank(s)).collect(Collectors.toList()), ";");
        System.out.println(join);
    }

    public void setXx(User user) {
        user.setName(this.xx);
    }
}

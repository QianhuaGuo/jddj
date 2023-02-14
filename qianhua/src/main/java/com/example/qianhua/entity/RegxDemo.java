package com.example.qianhua.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDemo {

    public static void main(String[] args) {
        String html = "<img src=\"https://img.alicdn.com/imgextra/i3/2207267310834/O1CN01lKk0AP1I2111MPPWW_!!2207267310834.png\" align=\"absmiddle\"><img src=\"https://img.alicdn.com/imgextra/i4/2207267310834/O1CN01zMs2oK1I21124ejEG_!!2207267310834.png\" align=\"absmiddle\">";
        List<String> l = new ArrayList<>();
        String pattern = "<img [^>]+>";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(html);
        while (matcher.find()){
            l.add(matcher.group());
        }
    }
}

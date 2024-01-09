package com.example.qianhua.demo;

public class RegexDemo {
    public static void main(String[] args) {
        String url = "APPLE主图视频_45441f92-4f36-4eb4-8f65-063dba3000eb.mp4";

        System.out.println(url.length());
        

        String s = "xss天猫平台接口返回：sizeMapping:CHK_SIZE_REQUIRED_FIELD_IS_EMPTY:尺码&apos;XS&apos;在尺码表中的必填字段尚未填写xxx;天猫平台接口返回：sizeMapping:CHK_SIZE_REQUIRED_FIELD_IS_EMPTY:尺码&apos;XS&apos;在尺码表中的必填字段尚未填写";
        String s1 = "天猫平台接口返回：sizeMapping:CHK_SIZE_REQUIRED_FIELD_IS_EMPTY:尺码&apos;XS&apos;在尺码表中的必填字段尚未填写";

        String s2 = "尺码表必填字段未填。";

        s = s.replaceAll(s1, s2);
        System.out.println(s);
    }
}

package com.example.qianhua.test;

import org.apache.commons.codec.binary.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        // 原始Base64编码字符串
        String base64String = "abc123+/=";

        // 使用Apache Commons Codec库进行URL安全解码
        byte[] decodedBytes = Base64.decodeBase64(base64String);
        String decodedString = new String(decodedBytes);

        System.out.println("原始Base64编码: " + base64String);
        System.out.println("URL安全编码: " + decodedString);
    }
}

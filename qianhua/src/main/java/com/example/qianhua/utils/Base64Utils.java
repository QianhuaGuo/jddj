package com.example.qianhua.utils;

//import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static void main(String[] args) {
        String remoteUrl = "https://scm-ross-uat.oss-cn-shanghai.aliyuncs.com/image/genimg/1618454033334/_BI1443/DY0501_Z/black/DY0501_Z-%E9%A2%9C%E8%89%B2%E5%9B%BE-black.jpg?etag=1618454035892";
//        String base64 = base64_encode(remoteUrl);
//        System.out.println(base64);

//        String base64ToUrl = base64ToUrl(base64);
//        System.out.println();
//        System.out.println(base64ToUrl);

        String urlToBase64 = urlToBase64(remoteUrl);
        String base64ToUrl = base64ToUrl(urlToBase64);

    }

    public static String base64_encode(String url){
        String base64encode = null;
        InputStream inputStream = null;
        try{
            //1.创建URL对象
            URL url1 = new URL(url);

            //2.打开链接，并获取链接中的流
            URLConnection urlConnection = url1.openConnection();
            inputStream = urlConnection.getInputStream();

            //3.读取流中的数据
            byte[] buffer = new byte[4096];
            int index;
            StringBuilder stringBuilder = new StringBuilder();
            while ((index = inputStream.read(buffer))!= -1){
                stringBuilder.append(new String(buffer,0,index));
            }
            String data = stringBuilder.toString();

            //4.字符串转base64编码
            byte[] encode = Base64.getEncoder().encode(data.getBytes());
            base64encode = new String(encode);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != inputStream){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }

        return base64encode;

    }

    public static String base64ToUrl(String base64String){
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] byteArray = decoder.decode(base64String);
//
//        Base64.Encoder encoder = Base64.getUrlEncoder();
//        String urlSafeBase64String = encoder.encodeToString(byteArray);
//        // 使用Apache Commons Codec库进行URL安全解码
////        byte[] decodedBytes = Base64.decodeBase64(base64String);
////        String urlSafeBase64String = new String(decodedBytes,StandardCharsets.UTF_8);
//
//        System.out.println("原始Base64编码: " + base64String);
//        System.out.println("URL安全编码: " + urlSafeBase64String);


        // 将Base64编码的URL进行解码
        byte[] decodedBytes = Base64.getUrlDecoder().decode(base64String);
        String decodedUrl = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("解码后的URL: " + decodedUrl);
        return decodedUrl;
    }



    public static String urlToBase64(String url){
        // 将URL进行Base64编码
        String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64编码后的URL: " + encodedUrl);
        return encodedUrl;
    }
}

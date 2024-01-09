package com.example.qianhua.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {


    public static SecretKey getKey(String strKey) {
        try {
            KeyGenerator _generator = KeyGenerator.getInstance( "AES" );
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128,secureRandom);
            return _generator.generateKey();
        }  catch (Exception e) {
            throw new RuntimeException( " 初始化密钥出现异常 " );
        }
    }
    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            SecretKey secretKey = getKey(password);
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            SecretKey secretKey = getKey(password);
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public static void main(String[] args){
//        String password = "12345678";
//        byte[] encrypt = AESUtil.encrypt("12345678", password);
//        System.out.println(encrypt);
//        System.out.println(new String(AESUtil.decrypt(encrypt,password),StandardCharsets.UTF_8));
//        System.out.println(AESUtil.parseByte2HexStr(AESUtil.encrypt("12345678", "12345678")));

        String decodedUrl = "https://scm-dam.oss-cn-shanghai.aliyuncs.com/image/genimg/baozun/ikea/DIPGU-0cuvvf000pinkrj1m2mc/synchronous8/%E4%B8%BB%E5%9B%BE%E8%A7%86%E9%A2%91/TMALL/synchronous8-%E4%B8%BB%E5%9B%BE%E8%A7%86%E9%A2%91.mp4?etag=1703239888201";
        String localFile = decodedUrl.substring(decodedUrl.lastIndexOf("/")+1,decodedUrl.indexOf(".mp4")+4);
        System.out.println(localFile);


//        String name = "郭千华";
//        byte[] b1 = name.getBytes();
//        byte[] b2 = name.getBytes(StandardCharsets.UTF_8);
//        System.out.println("b1.length:"+b1.length);
//        System.out.println("b2.length:"+b2.length);
//
//        System.out.println("b1:"+JSONObject.toJSONString(b1));
//        System.out.println("b2"+JSONObject.toJSONString(b2));
//
//        char[] ch = new char[100];
//
//
//        for (int m = 0;m<b1.length;m++){
//            b1[m] = (byte) m;
//            System.out.println(b1[m]);
//        }
    }

}

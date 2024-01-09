package com.example.qianhua.jddc.util;

import java.util.Random;

public class FixDigtUtils {

    public static String generate(int length){
        StringBuffer sb = new StringBuffer(length);
        String cahracters = "0123456789";
        Random random = new Random(10);

        for (int i = 0;i<length;i++){
            int index = random.nextInt(cahracters.length());
            sb.append(cahracters.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {


//        for (int i = 0;i<10;i++){
            System.out.println(generate(10));
//        }

    }
}

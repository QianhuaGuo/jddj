package com.example.qianhua.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {

        System.out.println(16>>>2);

        long a = 1234567876545654L;
        System.out.println(a % 16384);

        System.out.println(getHashCode("aa"));;

//        File f1 = new File("bb.xlsx");
//        f1.createNewFile();
//        if (f1.isDirectory()){
//            System.out.println("directory");
//        }
//        if (f1.isFile()){
//            System.out.println("file");
//        }
//
//        String path = System.getProperty("user.dir");
//        File tempFile = new File(path,"temppp");
//        if (!tempFile.exists()){
//            tempFile.mkdirs();
//        }
    }

    public static int getHashCode(Object key){
            int h = key.hashCode();

            return h ^ (h >>> 16);
    }
}

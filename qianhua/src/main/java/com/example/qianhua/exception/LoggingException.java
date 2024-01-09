package com.example.qianhua.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));

    }

    public static void main(String[] args) {
        Bean1 b1 = new Bean1(127);
        Bean2 b2 = new Bean2(127);
        if (b1.getPry() == b2.getPp()){
            System.out.println("相等");
        }

//        try{
//            ArrayList<String> list = new ArrayList<>();
//            String s = list.get(10);
////            throw new Exception("my...");
//        }catch (Exception e){
//            throw new RuntimeException(e.getMessage(),e);
////            e.printStackTrace();
////            System.out.println("=============");
////            System.out.println(e.getMessage());
////            System.out.println("=================");
////            System.out.println(e);
//        }
    }
    public static class Bean1{
        private Integer pry;

        Bean1(Integer p){
            pry = p;
        }

        public Integer getPry() {
            return pry;
        }
    }

    public static class Bean2{
        private Integer pp;
        Bean2(Integer p){
            pp = p;
        }

        public Integer getPp() {
            return pp;
        }
    }
}

package com.example.qianhua.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));

    }

    public static void main(String[] args) {
        try{
            throw new Exception("my...");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("=============");
            System.out.println(e.getMessage());
            System.out.println("=================");
            System.out.println(e);
        }
    }
}

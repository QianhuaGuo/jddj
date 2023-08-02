package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@Data
@EqualsAndHashCode
public class Dad implements Serializable {
    private static final long serialVersionUID = -7153520475610140865L;

    //姓氏
    private String lastName;


    public static void main(String[] args) {
        String schemaCode = "A1-01-01-02";
        String schemaPath = ",A1,A1-01,A1-01-01,A1-01-01-02,";
        schemaPath = schemaPath.substring(1,schemaPath.length()-1);
        String[] split = schemaPath.split(",");
        List<String> list =Arrays.asList(split);

        int i = list.indexOf("A1-01-01-02");
        System.out.println("i:"+i);
        System.out.println(list.get(i-1));


        Dad.printTrack();
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String name = "货品待审价格示例.xlsx";
//
//        String encode = java.net.URLEncoder.encode(name, "utf-8");
//        System.out.println(encode);
//    }


    /**
     * 打印当前线程的调用堆栈
     *
     */
    public static void printTrack(){
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        System.out.println("st = "+JSONObject.toJSONString(st));
        if(st==null){
            System.out.println("无堆栈...");
            return;
        }
        StringBuffer sbf =new StringBuffer();
        for(StackTraceElement e:st){
            if(sbf.length()>0){
                sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
                    ,e.getClassName()
                    ,e.getMethodName()
                    ,e.getLineNumber()));
        }
        System.out.println(sbf.toString());
    }
}

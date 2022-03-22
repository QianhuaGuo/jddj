package com.example.qianhua;

import lombok.Getter;

public enum ChannelCodeEnum {

    JDDJ("JDDJ","京东到家"),
    TMALL("TMALL","天猫")
    ;

    @Getter
    private String code;

    @Getter
    private String name;



    ChannelCodeEnum(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public static ChannelCodeEnum valueOf(String code,boolean isIgnoreCase){
        for (ChannelCodeEnum channelCodeEnum : values()){
            if ((isIgnoreCase && channelCodeEnum.getCode().equalsIgnoreCase(code))
            || (!isIgnoreCase && channelCodeEnum.getCode().equals(code))){
                return channelCodeEnum;
            }
        }
        return null;
    }

//    public static void main(String[] args) {
////        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.valueOf("jddj",true);
//        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.valueOf("JDDJ",false);
//        System.out.println(channelCodeEnum);
//    }
}

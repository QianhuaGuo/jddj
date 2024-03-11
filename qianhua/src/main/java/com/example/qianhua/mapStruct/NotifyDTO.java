package com.example.qianhua.mapStruct;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NotifyDTO {
    private String userName;

    private String passWord;

    private Integer age;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birty;
}

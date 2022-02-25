package com.example.qianhua.entity;

import lombok.Data;

@Data
public class AttrEntity {
    private String id;
    private String saasTenantCode;
    private String column;
    private String columnName;
    private Boolean standalone = Boolean.TRUE;
}

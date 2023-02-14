package com.example.qianhua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttrEntity {
    private String id;
    private String saasTenantCode;
    private String column;
    private String columnName;
    private Boolean standalone = Boolean.TRUE;
}

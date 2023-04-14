package com.example.qianhua.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class I18MessageSendRequestDTO {

    @ApiModelProperty(value = "来自哪个应用",required = true)
    private String fromApp;

    @ApiModelProperty(value = "发到哪个应用, 如果为空, 默认为fromApp")
    private String toApp;

    @ApiModelProperty(value = "调用人uac的id")
    private Long senderUserId;

    @ApiModelProperty(value = "消息类型任务提醒 TASK_ALERT 系统公告 SYSTEM_ANNOUNCE 默认系统公告")
    private String msgType = "TASK_ALERT";

    @ApiModelProperty(value = "消息标题",required = true)
    private String title;

    @ApiModelProperty(value = "消息体内容",required = true)
    private String body;

    @ApiModelProperty(value = "收件人列表",required = true)
    private String[] uacUserIds;

    @ApiModelProperty(value = "消息要跳转的url")
    private String url;

    public I18MessageSendRequestDTO(String[] uacUserIds,String title,String body){
        this.uacUserIds = uacUserIds;
        this.title = title;
        this.body = body;
    }
}

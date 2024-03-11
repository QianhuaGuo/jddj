package com.example.qianhua.mapStruct;

import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface NotifyConvertMapper {

    NotifyDTO convertNotifyEntity(NotifyEntity entity);
}

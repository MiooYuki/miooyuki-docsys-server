package com.miooyuki.docsystem.common.enums;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum {

    SUCCESS(200,"响应成功。"),
    NOT_FOUND(404, "资源不存在。"),
    SYSTEM_ERROR(500,"系统错误。"),
    PARAM_ERROR(501,"参数错误。");

    private final Integer code;

    private final String message;

    ResponseStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}

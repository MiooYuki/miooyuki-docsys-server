package com.miooyuki.docsystem.common;

import com.miooyuki.docsystem.common.enums.ResponseStatusEnum;
import lombok.Data;

@Data
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseResult() {

    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResponseResult(ResponseStatusEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    /**
     * 业务成功返回业务代码和描述信息
     */
    public static ResponseResult<Void> success() {
        return new ResponseResult<Void>(ResponseStatusEnum.SUCCESS, null);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseStatusEnum.SUCCESS, data);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> ResponseResult<T> success(ResponseStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new ResponseResult<T>(resultStatus, data);
    }

    /**
     * 业务异常返回业务代码和描述信息
     */
    public static <T> ResponseResult<T> failure() {
        return new ResponseResult<T>(ResponseStatusEnum.SYSTEM_ERROR, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> ResponseResult<T> failure(ResponseStatusEnum resultStatus) {
        return failure(resultStatus, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> ResponseResult<T> failure(ResponseStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new ResponseResult<T>(ResponseStatusEnum.SYSTEM_ERROR, null);
        }
        return new ResponseResult<T>(resultStatus, data);
    }

    public static <T> ResponseResult<T> failure(Integer code, String message) {
        return new ResponseResult<T>(code, message);
    }

}

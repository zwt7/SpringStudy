package com.swgger.demo.exception;


import com.swgger.demo.common.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
//    错误码
    protected Integer code;
//    错误信息
    protected  String message;

    public CustomException(ExceptionType type){
        this.code=type.getCode();
        this.message=type.getMsg();
    }
}

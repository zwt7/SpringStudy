package com.custom.demo.controller;


import com.custom.demo.pojo.ValidatorObj;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class VallidatorController {

    @PostMapping(value = "/validate")
    public Map<String, Object> validate(@Valid @RequestBody ValidatorObj obj, Errors errors) {
        Map<String, Object> errMap = new HashMap<>();
        // 获取错误列表
        List<ObjectError> objectErrors = errors.getAllErrors();
        for (ObjectError error : objectErrors) {
            String key = null;
            String msg = null;
            // 字段错误
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                // 获取错误验证字段名
                key = fieldError.getField();
            } else {
                // 非字段错误
                // 获取验证对象名称
                key = error.getObjectName();
            }
            // 错误信息
            msg = error.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }
}

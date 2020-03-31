package com.custom.demo.controller;


import com.custom.demo.pojo.Message;
import com.custom.demo.pojo.ValidatorObj;
import com.custom.demo.validator.MessageValidator;
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
public class CustomVallidatorController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 绑定验证器
        binder.setValidator(new MessageValidator());
        // 定义日期参数格式，参数不再需注解@DateTimeFormat，boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @GetMapping("/msgValidator")
    public Map<String, Object> validator(@Valid Message msg, Errors Errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("date", date);
        // 判断是否存在错误
        if (Errors.hasErrors()) {
            // 获取全部错误
            List<ObjectError> objErrors = Errors.getAllErrors();
            for (ObjectError error : objErrors) {
                // 判定是否字段错误
                if (error instanceof FieldError) {
                    // 字段错误
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    // 对象错误
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }
}

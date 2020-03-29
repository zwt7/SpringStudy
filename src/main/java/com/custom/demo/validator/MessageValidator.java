package com.custom.demo.validator;

import com.custom.demo.pojo.Message;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @date:2020/3/28 13:54
 * @destription:用户自定义验证器
 */

public class MessageValidator implements Validator {
   @Override
   public boolean supports(Class<?> clazz){
       return clazz.equals(Message.class);
   }

   @Override
   public void validate(Object target, Errors errors){
           if(target==null){
//  直接在参数处报错，这样就不能进入控制器的方法了
               errors.rejectValue("", null, "消息不能为空");
               return;
           }
           // 强制转换
           Message message = (Message) target;
           // 用户名非空串
           if (StringUtils.isEmpty(message.getText())) {
               // 增加错误，可以进入控制器方法
               errors.rejectValue("text", null, "正文不能为空");
           }
   }

}

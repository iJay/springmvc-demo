package org.example.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 为Rest风格开发的控制器类做增强 这里用于标识当前类为REST风格对应的异常处理器
// 此注解自带@ResponseBody注解与@Component注解，具备对应的功能
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 设置指定异常的处理方案，功能等同于控制器方法，出现异常后终止原始控制器执行，并转入当前方法执行
    // 此类方法可以根据处理的异常不同，制作多个方法分别处理对应的异常
    // @ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(Exception.class)
    public ResponseResult doOtherException (Exception exception) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员,异常对象发送给开发人员
        return new ResponseResult(BizCode.SYSTEM_UNKNOW_ERR, "系统繁忙，请稍后再试！");
    }

    @ExceptionHandler(SystemException.class)
    public ResponseResult doSystemException(SystemException systemException) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员,异常对象发送给开发人员
        return new ResponseResult(systemException.getCode(),null, systemException.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseResult doBusinessException(BusinessException businessException) {
        return new ResponseResult(businessException.getCode(),null, businessException.getMessage());
    }
}

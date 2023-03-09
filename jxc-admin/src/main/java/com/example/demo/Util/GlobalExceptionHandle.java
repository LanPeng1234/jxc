package com.example.demo.Util;


import com.example.demo.execptions.ParamsException;
import com.example.demo.model.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//全局异常
@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ParamsException.class)//指定处理什么异常
    @ResponseBody
    public RespBean paramsExceptionHandler(ParamsException e){
        return RespBean.error(e.getMsg());
    }
    @ExceptionHandler(Exception.class)//指定处理什么异常
    @ResponseBody
    public RespBean exceptionHandler(Exception e){
        return RespBean.error(e.getMessage());
    }
}

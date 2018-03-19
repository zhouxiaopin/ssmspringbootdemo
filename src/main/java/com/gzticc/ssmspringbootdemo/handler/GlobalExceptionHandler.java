package com.gzticc.ssmspringbootdemo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        //这里不是最好的做法
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("msg",e.getMessage());
        return modelMap;
    }
}

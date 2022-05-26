package com.gxa.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Component
@ControllerAdvice
public class MyHandlerException {
    @ExceptionHandler(value = UnauthorizedException.class)
    public String unauthorizedException(){
        System.out.println("没有权限！");
        return "unauthorized";
    }

}

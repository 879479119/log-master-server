package com.logmaster.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Error {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Exception rest(Exception e) {
        return e;
    }
}

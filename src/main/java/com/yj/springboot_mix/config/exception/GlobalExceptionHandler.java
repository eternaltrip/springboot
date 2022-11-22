package com.yj.springboot_mix.config.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends Exception {


    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public String SQLExceptionHandler(SQLException e){
        log.error("数据库语句错误" , e);
        return "数据库执行错误，请查看日志了解详情!";
    }

}

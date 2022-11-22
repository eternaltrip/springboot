package com.yj.springboot_mix.controller;



import com.yj.springboot_mix.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private OrderMapper orderMapper;


    @RequestMapping("/ok")
    public String test(){
        return "ok";
    }

    @RequestMapping("/get")
    public String get(){
         orderMapper.getByOrderNum("123");
        return"1";
    }
}

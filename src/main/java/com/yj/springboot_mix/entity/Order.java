package com.yj.springboot_mix.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("order")
@Data
public class Order {

    private String id;
    private String orderAmount;
    private String desc;
    private String orderNum;


}

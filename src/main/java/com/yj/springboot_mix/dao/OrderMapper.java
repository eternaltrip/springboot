package com.yj.springboot_mix.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.springboot_mix.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {

        @Select("select * from order where orderNum=#{orderNum} and i =1")
        Order getByOrderNum(String orderNum);

}

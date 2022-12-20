package com.lzj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzj.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    int insert(Order order);

    int update(Integer id, Integer status);
}

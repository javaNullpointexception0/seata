package com.lzj.mapper;

import com.lzj.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    public int insert(Order order);

    public int update(Integer id, Integer status);
}

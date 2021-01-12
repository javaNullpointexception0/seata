package com.lzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    public void deduct(@Param("commodityCode") String commodityCode, @Param("count") int count);
}

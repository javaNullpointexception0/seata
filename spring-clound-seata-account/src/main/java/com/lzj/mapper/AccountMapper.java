package com.lzj.mapper;

import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    @Flush
    public void decrease(@Param("userId") String userId, @Param("money") Integer money);
}

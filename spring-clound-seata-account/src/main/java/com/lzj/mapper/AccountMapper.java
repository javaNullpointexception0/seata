package com.lzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    int decrease(@Param("userId") String userId, @Param("money") Integer money);

    int tryDecrease(@Param("userId") String userId, @Param("money") Integer money);

    int confirmDecrease(@Param("userId") String userId, @Param("money") Integer money);

    int cancelDecrease(@Param("userId") String userId, @Param("money") Integer money);
}

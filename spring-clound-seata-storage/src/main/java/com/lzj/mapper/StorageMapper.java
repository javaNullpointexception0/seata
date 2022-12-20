package com.lzj.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper{

    int deduct(@Param("commodityCode") String commodityCode, @Param("count") int count);

    /**
     * tcc try阶段
     * @param commodityCode
     * @param count
     */
    int tryDeduct(@Param("commodityCode") String commodityCode, @Param("count") int count);

    /**
     * tcc confirm阶段
     * @param commodityCode
     * @param count
     */
    int confirmDeduct(@Param("commodityCode") String commodityCode, @Param("count") int count);

    /**
     * tcc cancel阶段
     * @param commodityCode
     * @param count
     */
    int cancelDeduct(@Param("commodityCode") String commodityCode, @Param("count") int count);
}

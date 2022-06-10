package com.cshisan.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cshisan.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yuanbai
 * @date 2022/6/8 9:41
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}

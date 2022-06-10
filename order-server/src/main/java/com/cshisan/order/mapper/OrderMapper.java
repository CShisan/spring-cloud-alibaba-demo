package com.cshisan.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cshisan.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yuanbai
 * @date 2022/6/8 9:42
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

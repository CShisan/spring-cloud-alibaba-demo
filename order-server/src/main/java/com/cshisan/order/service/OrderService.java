package com.cshisan.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cshisan.order.entity.Order;
import com.cshisan.order.feign.StockFeign;
import com.cshisan.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanbai
 * @date 2022/6/8 9:49
 */
@Service
public class OrderService {
    private final StockFeign stockFeign;
    private final OrderMapper mapper;

    @Autowired
    public OrderService(StockFeign stockFeign, OrderMapper mapper) {
        this.stockFeign = stockFeign;
        this.mapper = mapper;
    }

    @SentinelResource(value = "PlaceOrder", blockHandler = "saveBlockHandler")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String save(Long productId, Integer total){
//        int a = 1/0;
        Order order = new Order();
        order.setUserId(9527L);
        order.setProductId(productId);
        order.setTotal(total);
        mapper.insert(order);
        return "下单成功：" + order + stockFeign.update(productId, total);
    }

    public String saveBlockHandler(Long productId, Integer total, BlockException e){
        return "下单被流控了";
    }
}

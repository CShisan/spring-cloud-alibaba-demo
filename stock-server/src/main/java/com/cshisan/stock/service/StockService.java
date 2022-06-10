package com.cshisan.stock.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cshisan.stock.entity.Stock;
import com.cshisan.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanbai
 * @date 2022/6/8 9:52
 */
@Service
public class StockService {
    private final StockMapper mapper;

    @Autowired
    public StockService(StockMapper mapper) {
        this.mapper = mapper;
    }

    public String update(Long productId, Integer total){
//        int a = 1/0;
        LambdaQueryWrapper<Stock> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Stock::getProductId, productId);
        Stock stock = mapper.selectOne(wrapper);
        stock.setTotal(stock.getTotal() - total);
        mapper.updateById(stock);
        return "库存: "+ (total < 0 ? "加" : "减") + total;
    }
}

package com.cshisan.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuanbai
 * @date 2022/6/7 15:50
 */
@FeignClient("stock-server")
@RequestMapping("/stock")
public interface StockFeign {
    /**
     * 更新库存
     *
     * @param productId productId
     * @param total total
     * @return tips
     */
    @GetMapping("/update/{productId}/{total}")
    String update(@PathVariable("productId") Long productId, @PathVariable("total") Integer total);
}

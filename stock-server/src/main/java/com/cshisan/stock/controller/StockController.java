package com.cshisan.stock.controller;

import com.cshisan.stock.config.StockServerConfig;
import com.cshisan.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanbai
 * @date 2022/6/7 14:17
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockServerConfig config;
    private final StockService stockService;

    @Autowired
    public StockController(StockServerConfig config, StockService stockService) {
        this.config = config;
        this.stockService = stockService;
    }

    @GetMapping("/username")
    public String username(){
        return "hello world".concat(config.getUsername());
    }

    @GetMapping("/update/{productId}/{total}")
    public String update(@PathVariable("productId") Long productId, @PathVariable("total") Integer total){
        return stockService.update(productId, total);
    }
}

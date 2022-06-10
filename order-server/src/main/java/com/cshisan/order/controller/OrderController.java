package com.cshisan.order.controller;

import com.cshisan.common.base.Result;
import com.cshisan.common.utils.ResultUtil;
import com.cshisan.order.config.OrderServerConfig;
import com.cshisan.order.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    private final OrderServerConfig config;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServerConfig config, OrderService orderService) {
        this.config = config;
        this.orderService = orderService;
    }

    @GetMapping("/info")
    public Result<String> username(){
        return ResultUtil.ok("hello, ".concat(config.getUsername()).concat(config.getAge()));
    }

    @GetMapping("/save/{productId}/{total}")
    public Result<String> save(@PathVariable("productId") Long productId, @PathVariable("total") Integer total){
        return ResultUtil.ok(orderService.save(productId, total));
    }
}

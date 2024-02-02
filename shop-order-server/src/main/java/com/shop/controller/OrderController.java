package com.shop.controller;

import com.shop.pojo.Order;
import com.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqxu
 * @Date 2024/02/02 11:53:44
 * @Comment shop-parent>Xuzq
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/save")
    public Order order(Long pid, Long uid) {
        return orderService.createOrder(pid,uid);
    }
}

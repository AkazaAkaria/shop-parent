package com.shop.service;

import com.shop.pojo.Order;

/**
 * @author zqxu
 * @Date 2024/02/02 11:50:41
 * @Comment shop-parent>Xuzq
 */
public interface OrderService {
    Order createOrder(Long productId, Long userId);
}

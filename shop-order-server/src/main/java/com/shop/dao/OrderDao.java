package com.shop.dao;

import com.shop.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zqxu
 * @Date 2024/02/02 11:48:31
 * @Comment shop-parent>Xuzq
 */
public interface OrderDao extends JpaRepository<Order, Long> {
}

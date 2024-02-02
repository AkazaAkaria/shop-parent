package com.shop.service;

import com.shop.dao.Product;

/**
 * @author zqxu
 * @Date 2024/02/01 22:31:50
 * @Comment shop-parent>Xuzq
 */
public interface ProductService {
    Product findByPid(Long pid);
}

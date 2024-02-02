package com.shop.service.impl;

import com.shop.dao.Product;
import com.shop.dao.ProductDao;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zqxu
 * @Date 2024/02/01 22:32:13
 * @Comment shop-parent>Xuzq
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Long pid) {
        return productDao.findById(pid).get();
    }
}

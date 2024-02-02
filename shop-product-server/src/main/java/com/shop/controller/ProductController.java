package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.dao.Product;
import com.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqxu
 * @Date 2024/02/01 22:33:23
 * @Comment shop-parent>Xuzq
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //商品信息查询
    @RequestMapping("/get")
    public Product findByPid(Long pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}

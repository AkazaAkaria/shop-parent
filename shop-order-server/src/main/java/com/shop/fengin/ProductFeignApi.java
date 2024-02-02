package com.shop.fengin;

import com.shop.dao.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zqxu
 * @Date 2024/02/02 16:59:41
 * @Comment shop-parent>Xuzq
 */
//name的名称一定要和商品服务的服务名保持一致
@FeignClient(name = "product-service",path = "/product")
public interface ProductFeignApi {
    @RequestMapping("/get")
    Product findByPid(@RequestParam("pid") Long pid);
}

package com.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.shop.dao.OrderDao;
import com.shop.dao.Product;
import com.shop.fengin.ProductFeignApi;
import com.shop.pojo.Order;
import com.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zqxu
 * @Date 2024/02/02 11:49:12
 * @Comment shop-parent>Xuzq
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductFeignApi productFeignApi;

//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Override
    public Order createOrder(Long productId, Long userId) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);
        //从nacos中获取服务地址
        //自定义规则实现随机挑选服务
        //远程调用商品微服务,查询商品信息
        /*List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        log.info("商品微服务有{}个实例", instances.size());
        int index = new Random().nextInt(instances.size());
        log.info("随机挑选了第{}个实例", index);
        ServiceInstance serviceInstance = instances.get(index);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = host+":"+port;
        log.info(">>从nacos中获取到的微服务地址为:" + url);*/
        Product product = null;
//        //远程调用商品微服务,查询商品信息
//         product = restTemplate.getForObject(
//                "http://product-service/product/get?pid="+productId,Product.class);
        //远程调用商品微服务,查询商品信息
         product = productFeignApi.findByPid(productId);
        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));

        //创建订单并保存
        Order order = new Order();
        order.setUid(userId);
        order.setUsername("叩丁狼教育");
        order.setPid(productId);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }
}

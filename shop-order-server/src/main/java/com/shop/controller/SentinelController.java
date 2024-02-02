package com.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zqxu
 * @Date 2024/02/02 17:18:21
 * @Comment shop-parent>Xuzq
 */
@RestController
public class SentinelController {
    @RequestMapping("/sentinel1")
    public String sentinel1(){
        //模拟一次网络延时
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel1";
    }
    @RequestMapping("/sentinel2")
    public String sentinel2(){
        return "测试高并发下的问题";
    }
}

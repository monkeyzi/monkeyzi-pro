package com.monkeyzi.mcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: 高yg
 * @date: 2019/1/6 13:50
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:eureka
 */
@EnableEurekaServer
@SpringBootApplication
public class MonkeyziEurekaApplication {
    public  static void main(String[] args){
        SpringApplication.run(MonkeyziEurekaApplication.class);
    }
}

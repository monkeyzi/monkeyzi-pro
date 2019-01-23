package com.monkeyzi.mcloud.sys;

import com.monkeyzi.mcloud.common.swagger.annotation.EnableMonkeyziSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 高yg
 * @date: 2018/12/22 22:44
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@EnableMonkeyziSwagger2
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.monkeyzi.mcloud.sys.api.feign")
@ComponentScan("com.monkeyzi.mcloud")
public class MonkeyziSysApplication {
    public  static void main(String[] args){
        SpringApplication.run(MonkeyziSysApplication.class,args);
    }
}

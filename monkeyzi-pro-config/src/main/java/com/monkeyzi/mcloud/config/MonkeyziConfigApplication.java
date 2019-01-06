package com.monkeyzi.mcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: 高yg
 * @date: 2018/12/22 22:33
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@EnableConfigServer
@SpringBootApplication
public class MonkeyziConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyziConfigApplication.class);
    }
}

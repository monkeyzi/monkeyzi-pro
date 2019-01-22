package com.monkeyzi.mcloud.sys.web;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 高yg
 * @date: 2019/1/22 23:04
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@RestController
public class MyController {

    @Resource
    private TaskExecutor taskExecutor;

    @RequestMapping(value = "/tt")
    public void test(){
        taskExecutor.execute(()->{
            System.out.println(777777+Thread.currentThread().getName());
        });


    }
}

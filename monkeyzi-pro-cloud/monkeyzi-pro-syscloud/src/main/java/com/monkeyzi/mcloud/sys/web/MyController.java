package com.monkeyzi.mcloud.sys.web;

import com.monkeyzi.mcloud.sys.api.entity.BlogComm;
import com.monkeyzi.mcloud.sys.service.BlogCommService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BlogCommService blogCommService;

    @RequestMapping(value = "/tt")
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        BlogComm blogComm=new BlogComm();
        blogComm.setComment("gguoguoguo");
        blogCommService.save(blogComm);
        taskExecutor.execute(()->{
            System.out.println(777777+Thread.currentThread().getName());
        });


    }
}

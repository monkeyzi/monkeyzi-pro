package com.monkeyzi.mcloud.common.core.annotation.aspect;

import com.monkeyzi.mcloud.common.core.annotation.CheckSignAnnotation;
import com.monkeyzi.mcloud.common.core.exception.BusinessException;
import com.monkeyzi.mcloud.common.core.utils.FastJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * @author: 高yg
 * @date: 2019/1/2 21:13
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Slf4j
@Aspect
@Order(0)
public class CheckSignAspect {

    @Around("@annotation(checkSignAnnotation)")
    public Object  around(ProceedingJoinPoint point,CheckSignAnnotation checkSignAnnotation) throws Throwable{
        // 类名
        String className=point.getTarget().getClass().getName();
        log.info("类名={}",className);
        Object[] args = point.getArgs();
        if (args.length == 0) {
            return null;
        }
        String requestData = FastJsonUtils.obj2String(args);
        log.info("参数={}",requestData);
        /*if (true){
            throw new BusinessException(333,"签名异常");
        }*/
        Object obj=point.proceed();
        log.info("签名正确");
        return obj;
    }
}

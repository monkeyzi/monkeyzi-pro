package com.monkeyzi.mcloud.common.log.aspect;

import com.monkeyzi.mcloud.common.core.utils.FastJsonUtils;
import com.monkeyzi.mcloud.common.log.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 高yg
 * @date: 2018/12/31 17:30
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:日志注解处理
 */
@Slf4j
@Aspect
@Order(1)
public class LogAspect {
    /**
     * 请求参数记录最大值
     */
    private static final int MAX_SIZE=2000;

    @Around("@annotation(LogAnnotation)")
    public Object around(ProceedingJoinPoint point, LogAnnotation LogAnnotation) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 类名
        String className=point.getTarget().getClass().getName();
        // 方法名
        String methodName=point.getSignature().getName();
        log.info("执行类名={},方法名={}",className,methodName);
        // 请求参数
        String params=handlerRequestParams(point);
        log.info("参数为={}",params);

        Object obj=null;
        // 开始时间
        Long startTime=System.currentTimeMillis();
        // 执行方法
        obj=point.proceed();
        String result=FastJsonUtils.obj2String(obj);
        log.info("执行结果为={}",result);
        // 结束时间
        Long endTime=System.currentTimeMillis();
        Long executeTime=endTime-startTime;
        log.info("执行时间为={}",executeTime);
        log.info("日志ok");

        return obj;
    }


    /**
     * 获取请求参数
     * @param joinPoint
     * @return
     */
    private String handlerRequestParams(ProceedingJoinPoint joinPoint) {
        try {
            Object[] args = joinPoint.getArgs();
            if (args.length == 0) {
                return null;
            }
            String requestData = FastJsonUtils.obj2String(args);
            if (requestData.length() > MAX_SIZE) {
                requestData = requestData.substring(MAX_SIZE);
            }
            return requestData;
        } catch (Exception e) {
            log.error("获取请求数据,出现错误={}", e.getMessage(), e);
        }
        return null;
    }



}

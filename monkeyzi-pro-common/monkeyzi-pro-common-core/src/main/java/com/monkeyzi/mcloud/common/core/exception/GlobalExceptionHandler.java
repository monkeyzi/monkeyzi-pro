package com.monkeyzi.mcloud.common.core.exception;

import com.monkeyzi.mcloud.common.core.enums.ErrorCodeEnum;
import com.monkeyzi.mcloud.common.core.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: 高yg
 * @date: 2019/1/1 11:40
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(Exception e, HttpServletRequest request) {
        //方法名
        String uri=request.getRequestURI();
        //请求方法
        String method=request.getMethod();
        //

        log.info("uri={},method={}",uri,method);
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return R.errorMsg(ErrorCodeEnum.GL500.getMsg());
    }

    /**
     * 参数校验异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String msg=fieldErrors.get(0).getDefaultMessage();
        log.warn("参数校验处理={}",msg);
        return R.error(ErrorCodeEnum.GL400.getCode(),msg);
    }
}

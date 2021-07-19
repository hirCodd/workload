package com.workloadaccount.system.exceptionhandler;


import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultEnum;
import com.workloadaccount.system.response.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result defaultExceptionHandler(Exception e) {
        e.printStackTrace();
        return ResultUtil.fail(ResultEnum.GLOBAL_EXCEPTION.getCode(), ResultEnum.GLOBAL_EXCEPTION.getMessage(),
                e.getMessage());
    }
}

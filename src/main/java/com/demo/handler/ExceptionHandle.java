package com.demo.handler;

import com.demo.base.Result;
import com.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

/**
 * description: 异常处理
 * author: Smile
 * date: 2017/4/23
 */
@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        return ResultUtil.error(0,e.getMessage());
    }
}

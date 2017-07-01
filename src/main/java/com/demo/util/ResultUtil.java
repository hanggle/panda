package com.demo.util;

import com.demo.base.Result;

/**
 * description: 返回结果工具类
 * author: Smile
 * date: 2017/4/23
 */
public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData("");
        return result;
    }

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    public static Result success(Integer code, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求失败");
        result.setData("");
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg("请求失败");
        result.setData(msg);
        return result;
    }
}

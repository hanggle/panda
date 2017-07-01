package com.demo.base;

import java.util.UUID;

/**
 * description:
 * author: Smile
 * date: 2017/4/23
 */
public class CommonUtil {

    public static String getUUID(){

       return UUID.randomUUID().toString().replaceAll("-","");
    }
}

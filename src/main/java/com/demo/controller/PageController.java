package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * author: Smile
 * date: 2017/4/26
 */
@Controller
public class PageController {

    @RequestMapping("test")
    public String test(){
        System.out.println("-----------------------------------------------------------");
        System.out.println(111);
        System.out.println("-----------------------------------------------------------");
        return "myResource/index.html";
    }
}

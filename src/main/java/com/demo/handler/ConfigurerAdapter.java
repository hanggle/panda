package com.demo.handler;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * description:
 * author: Smile
 * date: 2017/4/24
 */
public class ConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myResource/**").addResourceLocations("classpath:/myResource/");
        super.addResourceHandlers(registry);
    }
}

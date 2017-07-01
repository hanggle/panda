package com.demo.controller;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**  配置web设置，配置过滤器
 * description:
 * author: Smile
 * date: 2017/4/20
 */
@Configuration
public class WebConfiguration {
    /*
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("*//*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }*/

    public class MyFilter implements Filter {
        @Override
        public void destroy() {

        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(request, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {

        }
    }
}

package com.nan.config.mvcConfig;

import com.nan.component.LoginHandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 如果您想保留Spring Boot MVC功能，并且只想添加其他MVC配置（拦截器，格式化程序，视图控制器等），
 * 则可以添加自己@Configuration的type类 WebMvcConfigurerAdapter，
 * 但不添加 @EnableWebMvc。如果您希望提供的自定义实例RequestMappingHandlerMapping，
 * RequestMappingHandlerAdapter或者 ExceptionHandlerExceptionResolver可以声明一个WebMvcRegistrationsAdapter
 * 提供此类组件的实例。
 */


@Configuration
public class MymvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/what").setViewName("login");

    }



    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
           @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源springboot已经处理了无需再处理
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")//拦截所有请求
                        .excludePathPatterns("/","/index","/index.html","/user/login");

            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");




            }
        };
        return  adapter;


    }


    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocalResolver();
    }






}

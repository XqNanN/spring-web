package com.nan.config.dbconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return  new DruidDataSource();
    }


    /**
     * 配置druid监控
     *   1.配置一个servlet
     *   2.配置一个监控的filter
     *
     */


    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*"
        );
        Map<String,String> mapInit=new HashMap<>();
        mapInit.put("loginUsername","nan");
        mapInit.put("loginPassword","admin123");

        servletRegistrationBean.setInitParameters(mapInit);

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean  webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> mapInitFilter=new HashMap<>();
        mapInitFilter.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(mapInitFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return  filterRegistrationBean;
    }
}

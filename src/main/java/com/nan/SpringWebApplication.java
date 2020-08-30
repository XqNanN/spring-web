package com.nan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value ="com.nan.mapper")
public class SpringWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringWebApplication.class, args);
    }

}

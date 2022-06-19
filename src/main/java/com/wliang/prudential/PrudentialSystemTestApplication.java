package com.wliang.prudential;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wliang.prudential.mapper")
public class PrudentialSystemTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrudentialSystemTestApplication.class, args);
    }

}

package com.scau.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringbootRedisDemoApplication:主启动类
 *
 * @author chen
 * @date 2019/03/09
 */
@EnableCaching
@MapperScan(basePackages = "com.scau.redis.mapper")
@SpringBootApplication
public class SpringbootRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisDemoApplication.class, args);
    }

}

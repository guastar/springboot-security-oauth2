package com.lxg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: SpringBoot项目<br>
 * 使用 @EnableScheduling 开启支持定时任务
 * 使用 @EnableAsync 开启异步执行程序
 * @date 2018/04/19
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

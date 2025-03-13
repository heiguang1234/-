package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 18:40
 */
@SpringBootApplication(scanBasePackages = "com.hspedu.springcloud")
public class MemberConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerApplication.class,args);
    }
}

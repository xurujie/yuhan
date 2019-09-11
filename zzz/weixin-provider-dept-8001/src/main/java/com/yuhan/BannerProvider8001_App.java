package com.yuhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by ZeroV on 2018/11/6.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class BannerProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(BannerProvider8001_App.class, args);
    }
}

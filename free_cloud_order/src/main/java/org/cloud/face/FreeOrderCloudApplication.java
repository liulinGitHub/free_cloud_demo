package org.cloud.face;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/2 23:10
 * @Version 1.0
 */
@MapperScan("org.cloud.face.**.dao")
@EnableDiscoveryClient
@SpringCloudApplication
public class FreeOrderCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreeOrderCloudApplication.class, args);
    }
}

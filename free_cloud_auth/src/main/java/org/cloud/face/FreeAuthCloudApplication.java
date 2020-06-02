package org.cloud.face;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/1 0:05
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringCloudApplication
public class FreeAuthCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeAuthCloudApplication.class, args);
    }
}

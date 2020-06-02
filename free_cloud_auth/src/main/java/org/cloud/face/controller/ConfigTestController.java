package org.cloud.face.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/2 21:45
 * @Version 1.0
 */
@RestController
public class ConfigTestController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/test")
    public String getInfo() {
        return info;
    }
}

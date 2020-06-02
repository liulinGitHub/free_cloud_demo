package org.cloud.face.controller;

import org.cloud.face.service.OrderService;
import org.cloud.face.utils.ResponseBo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Describe 订单服务
 * @Author: 950103
 * @Date: 2020/6/2 23:32
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/query")
    public ResponseBo queryOrder() {
        return ResponseBo.newDataResponse(this.orderService.queryOrder());
    }
}

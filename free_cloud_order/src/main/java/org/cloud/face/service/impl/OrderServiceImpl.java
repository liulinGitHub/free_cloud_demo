package org.cloud.face.service.impl;

import org.cloud.face.dao.OrderMapper;
import org.cloud.face.entity.Order;
import org.cloud.face.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Describe 订单接口
 * @Author: 950103
 * @Date: 2020/6/3 0:01
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> queryOrder() {
        return this.orderMapper.selectOrder();
    }

    @Override
    public Order queryOrderDetails(Integer orderId) {
        return this.orderMapper.selectOrderDetails(orderId);
    }
}

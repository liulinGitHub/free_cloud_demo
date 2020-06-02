package org.cloud.face.service;

import org.cloud.face.entity.Order;

import java.util.List;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/2 23:33
 * @Version 1.0
 */
public interface OrderService {

    List<Order> queryOrder();
}

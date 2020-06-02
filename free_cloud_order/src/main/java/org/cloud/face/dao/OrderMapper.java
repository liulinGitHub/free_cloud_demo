package org.cloud.face.dao;

import org.cloud.face.entity.Order;

import java.util.List;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/3 0:02
 * @Version 1.0
 */
public interface OrderMapper {

    List<Order> selectOrder();
}

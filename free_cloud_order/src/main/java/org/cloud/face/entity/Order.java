package org.cloud.face.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Describe
 * @Author: 950103
 * @Date: 2020/6/3 0:03
 * @Version 1.0
 */
@Data
public class Order {

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("订单编号")
    private String orderCode;
}

package com.cbz.model.entity.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cbz.model.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("shop_order")
public class Order extends BaseEntity {

    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("购买物品名称")
    private String thingName;

}

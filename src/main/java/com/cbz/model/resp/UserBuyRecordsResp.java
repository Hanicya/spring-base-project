package com.cbz.model.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserBuyRecordsResp {

    @ApiModelProperty("用户名字")
    private String username;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("购买物品名称")
    private String thingName;
}

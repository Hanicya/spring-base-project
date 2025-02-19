package com.cbz.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbz.model.entity.shop.Order;
import org.springframework.stereotype.Repository;


@DS("dk")
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}

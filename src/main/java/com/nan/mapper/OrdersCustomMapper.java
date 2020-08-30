package com.nan.mapper;

import com.nan.pojo.OrdersCustom;

import java.util.List;

public interface OrdersCustomMapper {

    public List<OrdersCustom> getOrdersByUserID();

}

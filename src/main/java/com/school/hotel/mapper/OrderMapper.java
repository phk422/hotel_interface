package com.school.hotel.mapper;

import com.school.hotel.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    /**
     * 返回订单信息
     * @return
     */
    List<Order> getOrders(Integer startPage, Integer pageSize, String idCard, String phone, String roomTypeId, String status);

    Integer getTotalCount(String idCard, String phone, String roomTypeId, String status);

}

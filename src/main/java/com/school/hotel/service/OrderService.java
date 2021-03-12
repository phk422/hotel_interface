package com.school.hotel.service;

import com.school.hotel.pojo.PageBean;


public interface OrderService {

    Object getOrders(PageBean pageBean, String idCard, String phone, String roomTypeId, String status);
}

package com.school.hotel.service.impl;

import com.school.hotel.mapper.OrderMapper;
import com.school.hotel.pojo.Order;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Room;
import com.school.hotel.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/8
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public Object getOrders(PageBean pageBean, String idCard, String phone, String roomTypeId, String status) {
        if (pageBean == null) {
            return mapper.getOrders(null, null, null, null, null, null);
        }
        // 查询总记录数
        Integer totalCount = getTotalCount(idCard, phone, roomTypeId, status);
        // 获取当前页码
        Integer currentPage = pageBean.getCurrentPage();
        log.info("当前页码：" + currentPage);
        // 获取当前pageSize
        Integer pageSize = pageBean.getPageSize();
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        Integer startPage = (currentPage - 1) * pageSize;
        List<Order> orders = mapper.getOrders(startPage, pageSize,idCard, phone, roomTypeId, status);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(orders);
        return pageBean;
    }

    private Integer getTotalCount(String idCard, String phone, String roomTypeId, String status) {
        return mapper.getTotalCount(idCard, phone, roomTypeId, status);
    }
}

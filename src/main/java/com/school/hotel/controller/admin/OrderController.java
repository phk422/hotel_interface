package com.school.hotel.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Result;
import com.school.hotel.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/8
 **/
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/getOrders")
    public Result getOrders(@RequestBody(required = false) Map<String, Object> params) {
        if (params == null) return Result.success(service.getOrders(null, null, null, null, null));
        // 获取pageBean对象
        String pageBeanStr = JSON.toJSONString(params.get("pageBean"));
        // 获取idCard
        String idCard = (String) params.get("idCard");
        // 获取手机号码
        String phone = (String) params.get("phone");
        // 获取状态
        String status = (String) params.get("status");
        String roomTypeId = (String) params.get("roomTypeId");
        PageBean pageBean = null;
        if (pageBeanStr != null && pageBeanStr.length() > 0 && !pageBeanStr.equals("null")) {
            pageBean = JSON.parseObject(pageBeanStr, PageBean.class);
        }
        return Result.success(service.getOrders(pageBean, idCard, phone, roomTypeId, status));
    }
}

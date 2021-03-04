package com.school.hotel.controller.admin;

import com.alibaba.fastjson.JSON;
import com.school.hotel.annotation.UserLoginToken;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Result;
import com.school.hotel.pojo.RoomType;
import com.school.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/3
 **/
@RestController
@RequestMapping("/roomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService service;

    @UserLoginToken
    @PostMapping("/getRoomTypes")
    public Result getRoomTypes(@RequestBody Map<String, Object> params) {
        String pageBean = JSON.toJSONString(params.get("pageBean"));
        String name = JSON.toJSONString(params.get("name"));
        Integer status = Integer.parseInt(JSON.toJSONString(params.get("status")));
        PageBean<RoomType> roomTypes = service.getRoomTypes(JSON.parseObject(pageBean, PageBean.class), name, status);
        return Result.success(roomTypes);
    }

    @UserLoginToken
    @PostMapping("/updateRoomType")
    public Result updateRoomType(@RequestBody RoomType roomType) {
        return Result.success(service.updateRoomType(roomType));
    }

    @UserLoginToken
    @PostMapping("/deleteRoomType")
    public Result deleteRoomType(@RequestBody RoomType roomType) {
        return Result.success(service.deleteRoomType(roomType));
    }
}

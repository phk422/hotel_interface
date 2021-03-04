package com.school.hotel.controller.admin;

import com.alibaba.fastjson.JSON;
import com.school.hotel.annotation.UserLoginToken;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Result;
import com.school.hotel.pojo.Room;
import com.school.hotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/4
 **/
@Slf4j
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService service;

    @UserLoginToken
    @PostMapping("/getRooms")
    public Result getRooms(@RequestBody Map<String, Object> params) {
        String pageBeanStr = JSON.toJSONString(params.get("pageBean"));
        String roomTypeIdStr = JSON.toJSONString(params.get("roomTypeId"));
        String floorIdStr = JSON.toJSONString(params.get("floorId"));
        String statusStr = JSON.toJSONString(params.get("status"));
        String snStr = JSON.toJSONString(params.get("sn")).replaceAll("\"", "");
        PageBean pageBean = null;
        Long roomTypeId = null;
        Long floorId = null;
        Long status = null;
        String sn = null;
        if (!isNull(pageBeanStr)) {
            pageBean = JSON.parseObject(pageBeanStr, PageBean.class);
        }
        if (!isNull(roomTypeIdStr)) {
            roomTypeId = Long.parseLong(roomTypeIdStr);
        }
        if (!isNull(floorIdStr)) {
            floorId = Long.parseLong(floorIdStr);
        }
        if (!isNull(statusStr)) {
            status = Long.parseLong(statusStr);
            if (status == 3) status = null;
        }
        if (!isNull(snStr)) {
            sn = snStr;
        }
        Object res = service.getRooms(pageBean, roomTypeId,
                floorId, status, sn);
        return Result.success(res);
    }

    @UserLoginToken
    @PostMapping("/updateRoom")
    public Result updateRoom(@RequestBody Room room) {
        return Result.success(service.updateRoom(room));
    }

    private static boolean isNull(String str) {
        return str != null && str.equals("null");
    }

}

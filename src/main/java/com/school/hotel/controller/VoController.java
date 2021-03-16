package com.school.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Result;
import com.school.hotel.service.VoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/16
 **/
@RestController
@RequestMapping("/vo")
public class VoController {
    @Autowired
    private VoService service;

    @PostMapping("/getCheckinVo")
    public Result getCheckinVo(@RequestBody(required = false) Map<String, Object> params) {
        if (params == null) return Result.success(service.getCheckinVo(null, null, null, null,
                null, null, null));

        String pageBeanStr = JSON.toJSONString(params.get("pageBean"));
        String name = (String) params.get("name");
        String idCard = (String) params.get("idCard");
        String mobile = (String) params.get("mobile");
        String roomId = JSON.toJSONString(params.get("roomId"));
        if (roomId.equals("-1")) roomId = null;
        String roomTypeId = JSON.toJSONString(params.get("roomTypeId"));
        if (roomTypeId.equals("-1")) roomTypeId = null;
        String status = JSON.toJSONString(params.get("status"));
        if (status.equals("-1")) status = null;

        PageBean pageBean = JSONObject.parseObject(pageBeanStr, PageBean.class);
        Object checkinVo = service.getCheckinVo(pageBean, name, mobile, idCard,
                roomId == null ? null : Long.parseLong(roomId), roomTypeId == null ? null : Long.parseLong(roomTypeId),
                status == null ? null : Integer.parseInt(status));
        return Result.success(checkinVo);
    }
}

package com.school.hotel.controller.admin;

import com.school.hotel.annotation.UserLoginToken;
import com.school.hotel.pojo.Floor;
import com.school.hotel.pojo.Result;
import com.school.hotel.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/3
 **/
@RestController
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    private FloorService service;

//    @UserLoginToken
    @PostMapping("/getFloors")
    public Result getFloors(@RequestBody Map<String, String> map) {
        return Result.success(service.getFloors(map.get("name")));
    }

    @UserLoginToken
    @PostMapping("/updateFloor")
    public Result updateFloor(@RequestBody Floor floor) {
        return Result.success(service.updateFloor(floor));
    }

    @UserLoginToken
    @PostMapping("/deleteFloorById")
    public Result deleteFloorById(@RequestBody Map<String, Long> map) {
        return Result.success(service.deleteFloorById(map.get("id")));
    }

    @PostMapping("/addFloor")
    public Result addFloor(@RequestBody Floor floor) {
        return Result.success(service.addFloor(floor));
    }
}

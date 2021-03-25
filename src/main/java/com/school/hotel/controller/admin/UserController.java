package com.school.hotel.controller.admin;

import com.alibaba.fastjson.JSON;
import com.school.hotel.annotation.UserLoginToken;
import com.school.hotel.pojo.Account;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Result;
import com.school.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/2/28
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @UserLoginToken
    @GetMapping("/findUsers")
    public Result test() {
        return Result.success(userService.findUsers());
    }

    @UserLoginToken
    @PostMapping("/getAccounts")
    public Result getAccounts(@RequestBody Map<String, Object> params) {
        log.debug("获取客户信息列表");
        String pageBean = JSON.toJSONString(params.get("pageBean"));
        String name = JSON.toJSONString(params.get("name"));
        String idCard = JSON.toJSONString(params.get("idCard"));
        PageBean p = userService.getAccounts(JSON.parseObject(pageBean, PageBean.class),
                name,
                idCard);
        return Result.success(p);
    }

    @UserLoginToken
    @PostMapping("/deleteCountById")
    public Result deleteCountById(@RequestBody Map<String, Integer> params) {
        return Result.success(userService.deleteCountById(params.get("id")));
    }

    @UserLoginToken
    @PostMapping("/updateAccount")
    public Result updateAccount(@RequestBody Account account) {
        return Result.success(userService.updateAccount(account));
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        return Result.success(userService.register(account));
    }

    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        return Result.success(userService.login(account));
    }
}

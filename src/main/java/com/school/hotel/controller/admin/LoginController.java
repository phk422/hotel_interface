package com.school.hotel.controller.admin;

import com.school.hotel.pojo.Result;
import com.school.hotel.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/2
 **/
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/userLogin")
    public Object login(@RequestBody Map<String, String> params) {
        Result result = loginService.login(params.get("username"), params.get("password"));
        return result;
    }

    @PostMapping("/logout")
    public Object logout(String token) {
        log.debug("退出登录" + token);
        return Result.success("退出登录！");
    }

    @GetMapping("/a")
    public String s() {
        return "哈哈哈";
    }

}

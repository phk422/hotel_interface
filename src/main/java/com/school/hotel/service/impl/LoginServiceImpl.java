package com.school.hotel.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.school.hotel.mapper.UserMapper;
import com.school.hotel.pojo.Result;
import com.school.hotel.pojo.User;
import com.school.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/2
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Result login(String username, String password) {
        User user = userMapper.login(username, password);
        if (user != null) {
            // 生成token
            // 用户密码是密钥
            String token = JWT.create().withAudience(user.getId().toString())
                            .sign(Algorithm.HMAC256(user.getPassword()));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            return Result.success(jsonObject);
        }
        // 登录失败
        return Result.error("登陆失败！请检查用户名称或密码！");
    }
}

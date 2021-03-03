package com.school.hotel.service;
import com.school.hotel.pojo.Result;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/2
 **/
public interface LoginService {
    Result login(String username, String password);
}

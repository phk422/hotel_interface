package com.school.hotel.service;

import com.school.hotel.pojo.Account;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.User;

import java.util.List;

public interface UserService {
    Integer register(Account account);
    List<User> findUsers();
    User findUserById(Long id);
    PageBean getAccounts(PageBean pageBean, String name, String idCard);
    int deleteCountById(Integer id);
    int updateAccount(Account account);

    Account login(Account account);
}

package com.school.hotel.service.impl;

import com.school.hotel.mapper.UserMapper;
import com.school.hotel.pojo.Account;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.User;
import com.school.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/2/28
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer register(Account account) {
        return userMapper.addAccount(account);
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    /**
     * 获取客户信息列表
     *
     * @return
     */
    @Override
    public PageBean getAccounts(PageBean pageBean, String name, String idCard) {
        name = name.replace("\"", "");
        idCard = idCard.replace("\"", "");
        // 查询总记录数
        Integer totalCount = getTotalCount(name, idCard);
        // 获取当前页码
        Integer currentPage = pageBean.getCurrentPage();
        log.info("当前页码：" + currentPage);
        // 获取当前pageSize
        Integer pageSize = pageBean.getPageSize();
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        Integer startPage = (currentPage - 1) * pageSize;
        List<Account> accounts = userMapper.getAccounts(startPage, pageSize, name, idCard);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(accounts);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public int deleteCountById(Integer id) {
        return userMapper.deleteCountById(id);
    }

    @Override
    public int updateAccount(Account account) {
        return userMapper.updateAccount(account);
    }

    @Override
    public Account login(Account account) {
        return userMapper.getAccount(account);
    }


    public Integer getTotalCount(String name, String idCard) {
        return userMapper.getTotalCount(name, idCard);
    }
}

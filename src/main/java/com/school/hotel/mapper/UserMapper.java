package com.school.hotel.mapper;

import com.school.hotel.pojo.Account;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 */
public interface UserMapper {
    List<User> findUsers();

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(@Param("id") Long id);

    /**
     * 获取客户信息列表
     * @return
     */
    List<Account> getAccounts(@Param("startPage") Integer startPage,
                              @Param("pageSize") Integer pageSize,
                              @Param("name") String name,
                              @Param("idCard") String idCard);

    /**
     * 获取客户总数
     * @return
     */
    Integer getTotalCount(
            @Param("name") String name,
            @Param("idCard") String idCard);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteCountById(@Param("id") Integer id);

    /**
     * 修改account
     * @param account
     * @return
     */
    int updateAccount(Account account);

    /**
     * 增加account
     * @param account
     * @return
     */
    Integer addAccount(Account account);

    /**
     * 查询account
     * @param account
     * @return
     */
    Account getAccount(Account account);

    Integer getAccountByName(String name);
}

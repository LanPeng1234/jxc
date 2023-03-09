package com.example.demo.service;

import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Queue;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 老李
 * @since 2023-02-27
 */
public interface IUserService extends IService<User> {

    User login(String userName, String password);

    public User findUserByUserName(String userName);

    void updateUserInfo(User user);

    void updatePassword(String username,String oldPassword,String newPassword,String confirmPassword);
}

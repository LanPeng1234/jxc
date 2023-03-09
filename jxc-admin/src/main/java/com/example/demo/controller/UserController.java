package com.example.demo.controller;


import com.example.demo.execptions.ParamsException;
import com.example.demo.model.RespBean;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.mysql.cj.exceptions.SSLParamsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老李
 * @since 2023-02-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    //登录
    @RequestMapping("login")
    @ResponseBody
    //存session里方便后续操作
    public RespBean login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        session.setAttribute("user",user);
        return RespBean.success("用户登陆成功!");
    }
    /*
     *先获取用户的会话信息
     * 将最新的用户信息传到session
     */
    //用户信息更新
    @RequestMapping("setting")
    public String setting(HttpSession session){
        User user= (User) session.getAttribute("user");
        session.setAttribute("user", userService.getById(user.getId()));
        return "user/setting";
    }
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public RespBean updateUserInfo(User user){
        userService.updateUserInfo(user);
        return RespBean.success("用户信息更新成功");
    }
    //密码更新
    @RequestMapping("password")
    public String updatePassword(){
        return "user/password";
    }
    @RequestMapping("updatePassword")
    @ResponseBody
    public RespBean updatePassword(HttpSession session,String oldPassword,String newPassword,String confirmPassword){
        User user= (User) session.getAttribute("user");
        userService.updatePassword(user.getUsername(),oldPassword,newPassword,confirmPassword);
        return RespBean.success("密码更新成功");
    }
}

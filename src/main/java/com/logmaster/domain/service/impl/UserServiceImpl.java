package com.logmaster.domain.service.impl;

import com.logmaster.domain.model.*;
import com.logmaster.domain.service.UserService;
import com.logmaster.mapper.master.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserList(Pagination page) {
        return userMapper.getUserList(page);
    }

    @Override
    public Integer getUserNums() {
        return userMapper.getUserNums();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer getLoginId(String mail, String password) {
        return userMapper.getLoginId(mail, password);
    }
//
//    @Override
//    public String getUserPassword(String mail) {
//        return userMapper.getUserPassword(mail);
//    }

    @Override
    public List<User> userComplete(User user) {
        return userMapper.userComplete(user);
    }

}

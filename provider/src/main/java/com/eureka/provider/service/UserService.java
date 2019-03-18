package com.eureka.provider.service;

import com.eureka.provider.model.User;
import com.eureka.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserInfo(){
        return userMapper.findUserInfo();
    }
}
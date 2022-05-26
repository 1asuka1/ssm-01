package com.gxa.service.impl;

import com.gxa.entity.Emp;
import com.gxa.entity.User;
import com.gxa.mapper.UserMapper;
import com.gxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String name,String pwd) {

        User user = this.userMapper.getByNameAndPwd(name, pwd);
        return user;
    }

    @Override
    public User getByName(String name) {
        User user = this.userMapper.getByName(name);
        return user;
    }


}

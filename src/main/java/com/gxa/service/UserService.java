package com.gxa.service;

import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    User login(String name, String pwd);
    //根据用户名获取信息
    User getByName(@Param("name") String name);

}

package com.gxa.mapper;

import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
    User getByName(@Param("name") String name);
}

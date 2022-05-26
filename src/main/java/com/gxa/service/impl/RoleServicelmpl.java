package com.gxa.service.impl;

import com.gxa.entity.Role;
import com.gxa.mapper.RoleMapper;
import com.gxa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServicelmpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryAllRole() {
        List<Role> roles = roleMapper.queryAllRole();
        return  roles;
    }
}

package com.gxa.service.impl;

import com.gxa.entity.Permission;
import com.gxa.mapper.PermissionMapper;
import com.gxa.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public Set<String> queryPermissionByName(String name) {
        Set<String> permissions = this.permissionMapper.queryPermissionByName(name);
        return permissions;
    }
}

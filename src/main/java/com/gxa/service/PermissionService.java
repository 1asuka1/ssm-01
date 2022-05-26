package com.gxa.service;

import com.gxa.entity.Permission;

import java.util.Set;

public interface PermissionService {
    Set<String> queryPermissionByName(String name);
}

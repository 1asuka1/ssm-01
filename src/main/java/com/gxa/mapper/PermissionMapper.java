package com.gxa.mapper;

import com.gxa.entity.Permission;

import java.util.Set;

public interface PermissionMapper {
    Set <String>queryPermissionByName(String name);
}

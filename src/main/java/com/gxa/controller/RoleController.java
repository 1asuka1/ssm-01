package com.gxa.controller;

import com.gxa.entity.Role;
import com.gxa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/role/r")
    public String queryAllRole(Map map){
        List<Role> roles = roleService.queryAllRole();
        System.out.println(roles);
        map.put("roles",roles);
        return "role/roles";

    }
}

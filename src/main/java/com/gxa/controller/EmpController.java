package com.gxa.controller;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import com.gxa.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    //查询所有员工为get请求
    @GetMapping("/emp/emps")
    @RequiresPermissions(value={"emp:select"})
    public String queryAllEmp(Map map){
        List<Emp> emps = empService.queryAllEmp();
        emps.forEach(emp -> System.out.println(emp));
        map.put("emps",emps);
        System.out.println(emps);
        return "emp/list";

    }
    //获取部门信息
    @RequiresPermissions(value={"emp:add"})
    @GetMapping("/emp/preAdd")
    public String toadd(Map map){
        List<Dept> depts = empService.queryALLDept();
        map.put("depts",depts);
        return "emp/add";
    }
    //修改为post请求
    @PostMapping("/emp/add")
    @RequiresPermissions(value={"emp:add"})
    public String add(Emp emp,Map map) {
        emp.setStatus(1);
        empService.insertEmp(emp);
        return "redirect:/emp/emps";
    }
    //获取单个员工信息
    @GetMapping("/emp/{id}")
    @RequiresPermissions(value={"emp:update"})
    public String queryById(@PathVariable("id") Integer id, Map map){
        Emp emp = this.empService.queryById(id);
        List<Dept> depts = this.empService.queryALLDept();
        map.put("emp",emp);
        map.put("depts",depts);
        return "emp/edit";


    }

    //修改为Put请求
        @RequiresPermissions(value={"emp:update"})
        @PutMapping ("/emp/up")
        public String update(Emp emp){
        emp.setStatus(1);
        System.out.println(emp);
            empService.update(emp);
            return "redirect:/emp/emps";

    }
    @DeleteMapping("/emp/delete")
    @RequiresPermissions(value={"emp:del"})
    public String delete(Integer id){
        this.empService.deleteById(id);
        return "redirect:/emp/emps";

    }


//    @GetMapping("/emp/emps")
//    public String queryEmps(Map map){
//        List<Emp> emps = this.empService.queryEmps();
//
//        map.put("emps",emps);
//        return "emp/list";
//
//    }
//
//    @GetMapping("/emp/preAdd")
//    public String toAdd(Map map){
//        List<Dept> depts = this.empService.queryDepts();
//        map.put("depts",depts);
//
//        return "emp/add";
//
//    }
//
//    @PostMapping("/emp")
//    public String add(Emp emp){
//        System.out.println(emp);
//        emp.setStatus(1);
//
//        this.empService.add(emp);
//        return "redirect:/emp/emps";
//
//    }


}

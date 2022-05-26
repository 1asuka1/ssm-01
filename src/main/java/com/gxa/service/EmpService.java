package com.gxa.service;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;

import java.util.List;

public interface EmpService {
//    List<Emp> queryEmps();
//    List<Dept> queryDepts();
//    void add(Emp emp);
    //获取所有员工信息
    List <Emp> queryAllEmp();
    //获取部门信息
    List<Dept> queryALLDept();
    //添加新的员工
    void insertEmp(Emp emp);
    //修改员工
    void update(Emp emp);
    //获取单个员工信息
    Emp queryById(Integer id);
    //删除
    void deleteById(Integer id);
}

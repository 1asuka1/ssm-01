package com.gxa.mapper;

import com.gxa.entity.Emp;

import java.util.List;

public interface EmpMapper {
    //List<Emp> queryAll();
   // void insert(Emp emp);
    //获取所有雇员信息
    List <Emp> queryAllEmp();
    //添加新的员工
    void insertEmp(Emp emp);
    //修改员工
    void update(Emp emp);
    //修改---先获取员工信息
    Emp queryById(Integer id);
    //删除员工
    void deleteById(Integer id);
}

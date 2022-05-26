package com.gxa.service.impl;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import com.gxa.mapper.DeptMapper;
import com.gxa.mapper.EmpMapper;
import com.gxa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;
    @Transactional
    @Override
    public List<Emp> queryAllEmp() {
        List<Emp> emps = empMapper.queryAllEmp();
        emps.forEach(emp -> System.out.println(emp));
        return emps;
    }
    @Transactional
    @Override
    public List<Dept> queryALLDept() {
        List<Dept> depts = deptMapper.queryALLDept();
        return depts;
    }
    @Transactional
    @Override
    public void insertEmp(Emp emp) {
        this.empMapper.insertEmp(emp);

    }
    @Transactional
    @Override
    public void update(Emp emp) {
        this.empMapper.update(emp);

    }
    @Transactional
    @Override
    public Emp queryById(Integer id) {
        Emp emp = this.empMapper.queryById(id);

        return emp;
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
        this.empMapper.deleteById(id);

    }
//    @Override
//    public List<Emp> queryEmps() {
//
//        List<Emp> emps = this.empMapper.queryAll();
//        return emps;
//    }
//
//    @Override
//    public List<Dept> queryDepts() {
//        List<Dept> depts = this.deptMapper.queryAll();
//        return depts;
//    }
//
//    @Override
//    public void add(Emp emp) {
//        this.empMapper.insert(emp);
//    }


}

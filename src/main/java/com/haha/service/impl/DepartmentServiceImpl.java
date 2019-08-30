package com.haha.service.impl;

import com.alibaba.fastjson.JSON;
import com.haha.mapper.DepartmentMapper;
import com.haha.pojo.Department;
import com.haha.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Department")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public String SelectDepartmentAll() {
       List<Department> list = departmentMapper.SelectAll();
        return JSON.toJSONString(list);
    }
}

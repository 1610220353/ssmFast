package com.haha.service;

import com.haha.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询员工表+职务表+部门表并且实现分页
     */
    String selectAll(int page, int count,String employeeName,String DepartmentName);
    /**
     *实现对员工表格的添加
     */
    String insertEmployee(Employee employee);
    /**
     * 实现对表格的编辑操作
     */
    String updateEmployee(Employee employee);
    /**
     * 通过姓名或者部门表格进行查询
     */
}

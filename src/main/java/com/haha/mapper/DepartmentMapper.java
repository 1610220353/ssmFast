package com.haha.mapper;

import com.haha.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 查询部门表并对其操作
     */
    List<Department> SelectAll();
}

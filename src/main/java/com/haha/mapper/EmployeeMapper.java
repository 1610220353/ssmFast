package com.haha.mapper;

import com.haha.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 初始化列表
     */
    List<Employee> selectAll(@Param("page") int page, @Param("count") int count, @Param("employeeName") String employeeName, @Param("DepartmentName") String DepartmentName);

    /**
     * 执行添加业务
     */
    int insertEmployee(Employee employee);

    /**
     * 编辑操作
     */
    int updateEmployee(Employee employee);
}

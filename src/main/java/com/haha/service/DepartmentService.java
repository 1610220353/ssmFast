package com.haha.service;

import com.haha.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface DepartmentService {
/**
 *查询部门表格
 */
    String SelectDepartmentAll();

}

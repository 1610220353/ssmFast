package com.haha.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haha.mapper.EmployeeMapper;
import com.haha.pojo.Employee;
import com.haha.service.EmployeeService;
import com.haha.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selectEmployee")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public String selectAll(int page, int count,String employeeName,String DepartmentName) {

        JSONObject jsonObject = new JSONObject();
        page =page+count-10;
        List<Employee> list1 = employeeMapper.selectAll(0,0,employeeName,DepartmentName);
        jsonObject.put("total",list1.size());//记录总行数
        if(page>1){
            int start = (page-1)* CodeUtil.PAGE_SIZE;
           // list = employeeService.selectAll(start,CodeUtil.PAGE_SIZE);
            List<Employee> list = employeeMapper.selectAll(start,CodeUtil.PAGE_SIZE,employeeName,DepartmentName);

            jsonObject.put("rows",list);
        }else{
           //当前台传值为1时
            List<Employee> list = employeeMapper.selectAll(CodeUtil.PAGE_START,CodeUtil.PAGE_START,employeeName,DepartmentName);
            jsonObject.put("rows",list);

        }
        return String.valueOf(jsonObject);
    }


    @Override
    public String insertEmployee(Employee employee) {
        int i = employeeMapper.insertEmployee(employee);
        JSONObject jsonObject = new JSONObject();
        if(i==1){
            jsonObject.put("select", CodeUtil.RESULT_SUCCESS);
        }else{
            jsonObject.put("select",CodeUtil.RESULT_ERROR);
        }
        return String.valueOf(jsonObject);
    }

    @Override
    public String updateEmployee(Employee employee) {
        //对修改的操作
        int i= employeeMapper.updateEmployee(employee);
        JSONObject jsonObject = new JSONObject();
        if(i==1){
            jsonObject.put("update",CodeUtil.RESULT_SUCCESS);
        }else{
            jsonObject.put("update",CodeUtil.RESULT_ERROR);
        }
        return String.valueOf(jsonObject);
    }
}

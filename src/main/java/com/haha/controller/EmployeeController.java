package com.haha.controller;

import com.haha.pojo.Employee;
import com.haha.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/employee",produces = "text/plain;charset=utf-8")
/**
 * 对员工表格进行操作
 */
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/employeeAll")
    @ResponseBody
    public String selectAll(int page,int rows,String employeeName,String DepartmentName){
        //查询所有并且分页
        System.out.println(page+"-----"+rows);
        return  employeeService.selectAll(page,rows,employeeName,DepartmentName);
    }
    @RequestMapping("/addEmployee")
    @ResponseBody
    public String addEmployee(Employee employee){
        //添加事件
        return employeeService.insertEmployee(employee);
    }
    @RequestMapping("/employeeUpdate")
    @ResponseBody
    public String employeeUpdate(Employee employee){

        //System.out.println("hahah"+employee);
        //编辑事件
        return employeeService.updateEmployee(employee);
    }

}

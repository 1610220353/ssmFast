package com.haha.controller;

import com.haha.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/Department",produces = "text/plain;charset=utf-8")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(){
        //System.out.println("部门表格"+departmentService.SelectDepartmentAll());
        return departmentService.SelectDepartmentAll();
    }
}

package com.haha.controller;

import com.haha.service.PositionService;
import com.haha.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/Position",produces = "text/plain;charset=utf-8")
public class PositionController {
    @Autowired
//    自动注入组件
    private PositionService positionService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public String SelectAll(){
        //查询员工表
        return positionService.SelectAll();
    }

}

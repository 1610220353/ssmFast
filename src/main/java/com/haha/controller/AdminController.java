package com.haha.controller;

import com.haha.pojo.Admin;
import com.haha.service.AdminService;
import com.haha.util.CodeUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/admin",produces = "text/plain;charset=utf-8")
public class AdminController {
    //注入AdminService
    @Autowired
    private AdminService adminService;
  @RequestMapping(value = "/selectId")
  @ResponseBody
    public String selectid(Admin admin){
      Admin ad = adminService.selectId(admin);
      JSONObject jsonObject = new JSONObject();
        if(ad!=null){
            if(ad.getAdminAtate().equals("1")){
                //System.out.println("什么都正确"+CodeUtil.RESULT_SUCCESS);
                jsonObject.put("state",CodeUtil.RESULT_SUCCESS);
                jsonObject.put("data",ad);
            }else{
                //System.out.println("不符合");
                jsonObject.put("state","");
            }

      }else{
            //System.out.println("不存在");
            jsonObject.put("state",CodeUtil.RESULT_ERROR);
      }
      System.out.println(String.valueOf(jsonObject));
      return String.valueOf(jsonObject);
  }
    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public String selectAll(Admin admin){
          Admin ad = adminService.selectAll(admin);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",ad);
        return String.valueOf(jsonObject);
    }


}

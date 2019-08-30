package com.haha.service.impl;

import com.haha.mapper.AdminMapper;
import com.haha.pojo.Admin;
import com.haha.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectId(Admin admin) {
        return adminMapper.selectId(admin);
    }

    @Override
    public Admin selectAll(Admin admin) {

        return adminMapper.selectAll(admin);
    }
}

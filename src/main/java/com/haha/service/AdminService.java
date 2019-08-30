package com.haha.service;

import com.haha.pojo.Admin;

public interface AdminService {
    /**
     * 检查数据库
     */
    Admin selectId(Admin admin);
    Admin selectAll(Admin admin);
}

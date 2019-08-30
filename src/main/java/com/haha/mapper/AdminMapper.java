package com.haha.mapper;

import com.haha.pojo.Admin;

public interface AdminMapper {
    /**
     * 检查数据库
     */
    Admin selectId(Admin admin);
    Admin selectAll(Admin admin);

}

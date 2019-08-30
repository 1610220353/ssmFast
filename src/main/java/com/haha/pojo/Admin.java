package com.haha.pojo;

public class Admin {
    private Integer AdminID;//id
    private String AdminAccount;//用户账号
    private String AdminPwd;//用户密码
    private String AdminAtate;//用户状态
    private String AdminRight;//用户类型
    private String AdminName;//用户名称
    private String DepartmentName;//部门名称

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public Admin() {

    }

    public Admin(Integer adminID, String adminAccount, String adminPwd, String adminAtate, String adminRight, String adminName) {
        AdminID = adminID;
        AdminAccount = adminAccount;
        AdminPwd = adminPwd;
        AdminAtate = adminAtate;
        AdminRight = adminRight;
        AdminName = adminName;
    }

    public Integer getAdminID() {
        return AdminID;
    }

    public void setAdminID(Integer adminID) {
        AdminID = adminID;
    }

    public String getAdminAccount() {
        return AdminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        AdminAccount = adminAccount;
    }

    public String getAdminPwd() {
        return AdminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        AdminPwd = adminPwd;
    }

    public String getAdminAtate() {
        return AdminAtate;
    }

    public void setAdminAtate(String adminAtate) {
        AdminAtate = adminAtate;
    }

    public String getAdminRight() {
        return AdminRight;
    }

    public void setAdminRight(String adminRight) {
        AdminRight = adminRight;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }
}

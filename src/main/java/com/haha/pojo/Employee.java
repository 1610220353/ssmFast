package com.haha.pojo;


public class Employee {

    private Integer EmployeeID;//id
    private String EmployeeName;//员工姓名
    private String EmployeeGender;//员工性别（0，女 1，男）
    private Integer PositionID;//职务编号
    private Integer DepartmentID;//部门编号
    private String CardNumber;//员工卡号
    private String EmployeeState;//员工状态（1，正常 2停用）
    private String EmployeeMemo;//备注
    private String DepartmentName;//部门名称
    private String PositionName;//职务名称
    public Employee() {
    }



    public Employee(Integer employeeID, String employeeName, String employeeGender, Integer positionID, Integer departmentID, String cardNumber, String employeeState, String employeeMemo) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        EmployeeGender = employeeGender;
        PositionID = positionID;
        DepartmentID = departmentID;
        CardNumber = cardNumber;
        EmployeeState = employeeState;
        EmployeeMemo = employeeMemo;

    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeGender() {
        return EmployeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        EmployeeGender = employeeGender;
    }

    public Integer getPositionID() {
        return PositionID;
    }

    public void setPositionID(Integer positionID) {
        PositionID = positionID;
    }

    public Integer getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        DepartmentID = departmentID;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getEmployeeState() {
        return EmployeeState;
    }

    public void setEmployeeState(String employeeState) {
        EmployeeState = employeeState;
    }

    public String getEmployeeMemo() {
        return EmployeeMemo;
    }

    public void setEmployeeMemo(String employeeMemo) {
        EmployeeMemo = employeeMemo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeGender='" + EmployeeGender + '\'' +
                ", PositionID=" + PositionID +
                ", DepartmentID=" + DepartmentID +
                ", CardNumber='" + CardNumber + '\'' +
                ", EmployeeState='" + EmployeeState + '\'' +
                ", EmployeeMemo='" + EmployeeMemo + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", PositionName='" + PositionName + '\'' +
                '}';
    }
}
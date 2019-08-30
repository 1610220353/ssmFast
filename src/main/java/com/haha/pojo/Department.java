package com.haha.pojo;

public class Department {
    //部门表
    private Integer DepartmentID;//部门id
    private String DepartmentName;//
    private String StartTimeAM;//上午上班时间
    private String EndTimeAM;//上午下班时间
    private String StartTimePM;//下午上班时间
    private String EndTimePM;//下午下班时间
    private Integer ParentID;//父级部门编号


    public Department() {
    }

    public Department(Integer departmentID, String departmentName, String startTimeAM, String endTimeAM, String startTimePM, String endTimePM, Integer parentID) {
        DepartmentID = departmentID;
        DepartmentName = departmentName;
        StartTimeAM = startTimeAM;
        EndTimeAM = endTimeAM;
        StartTimePM = startTimePM;
        EndTimePM = endTimePM;
        ParentID = parentID;
    }

    public Integer getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getStartTimeAM() {
        return StartTimeAM;
    }

    public void setStartTimeAM(String startTimeAM) {
        StartTimeAM = startTimeAM;
    }

    public String getEndTimeAM() {
        return EndTimeAM;
    }

    public void setEndTimeAM(String endTimeAM) {
        EndTimeAM = endTimeAM;
    }

    public String getStartTimePM() {
        return StartTimePM;
    }

    public void setStartTimePM(String startTimePM) {
        StartTimePM = startTimePM;
    }

    public String getEndTimePM() {
        return EndTimePM;
    }

    public void setEndTimePM(String endTimePM) {
        EndTimePM = endTimePM;
    }

    public Integer getParentID() {
        return ParentID;
    }

    public void setParentID(Integer parentID) {
        ParentID = parentID;
    }
}
package com.haha.pojo;

public class Position {
    private Integer PositionID;
    private String PositionName;

    public Position() {
    }

    public Position(Integer positionID, String positionName) {
        PositionID = positionID;
        PositionName = positionName;
    }

    public Integer getPositionID() {
        return PositionID;
    }

    public void setPositionID(Integer positionID) {
        PositionID = positionID;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }
}

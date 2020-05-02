package com.example.pomik.studentraportichka.model;

public class StudentGroup {
    private String groupName;
    private int building;
    private int classRoom;

    public StudentGroup() {
    }

    public StudentGroup(String groupName, int building, int classRoom) {
        this.groupName = groupName;
        this.building = building;
        this.classRoom = classRoom;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }
}

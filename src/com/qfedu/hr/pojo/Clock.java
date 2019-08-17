package com.qfedu.hr.pojo;

public class Clock {
    private int id;
    private int userId;
    private String userName;
    public Clock() {
    }

    public Clock(int id, int userId, String userName) {
        this.id=id;
        this.userId=userId;
        this.userName=userName;
    }

    public Clock(int userId, String userName) {
        this.userId=userId;
        this.userName=userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId=userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}

package com.qfedu.hr.pojo;

public class Leave {
    private Integer id;
    private String userName;
    private String beginTime;
    private String endTime;
    private String reasons;
    private String conditioning;

    public Leave() {
    }

    public Leave(String userName, String beginTime, String endTime, String reasons, String conditioning) {
        this.userName=userName;
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.reasons=reasons;
        this.conditioning=conditioning;
    }

    public Leave(Integer id, String userName, String beginTime, String endTime, String reasons, String conditioning) {
        this.id=id;
        this.userName=userName;
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.reasons=reasons;
        this.conditioning=conditioning;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime=beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime=endTime;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons=reasons;
    }

    public String getConditioning() {
        return conditioning;
    }

    public void setConditioning(String conditioning) {
        this.conditioning=conditioning;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", reasons='" + reasons + '\'' +
                ", conditioning='" + conditioning + '\'' +
                '}';
    }
}

package com.qfedu.hr.pojo;

public class Train {
    private Integer id;
    private String name;
    private String purpose;
    private String beginTime;
    private String endTime;
    private String datum;
    private String teacher;
    private Integer studentId;
    private String createTime;
    private boolean educate;
    private String effect;
    private String summarize;

    public Train() {
    }

    public Train(String name, String purpose, String beginTime, String endTime, String datum, String teacher, Integer studentId, String createTime, boolean educate, String effect, String summarize) {
        this.name=name;
        this.purpose=purpose;
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.datum=datum;
        this.teacher=teacher;
        this.studentId=studentId;
        this.createTime=createTime;
        this.educate=educate;
        this.effect=effect;
        this.summarize=summarize;
    }

    public Train(Integer id, String name, String purpose, String beginTime, String endTime, String datum, String teacher, Integer studentId, String createTime, boolean educate, String effect, String summarize) {
        this.id=id;
        this.name=name;
        this.purpose=purpose;
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.datum=datum;
        this.teacher=teacher;
        this.studentId=studentId;
        this.createTime=createTime;
        this.educate=educate;
        this.effect=effect;
        this.summarize=summarize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose=purpose;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum=datum;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher=teacher;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId=studentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime=createTime;
    }

    public boolean isEducate() {
        return educate;
    }

    public void setEducate(boolean educate) {
        this.educate=educate;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect=effect;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize=summarize;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", datum='" + datum + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentId=" + studentId +
                ", createTime='" + createTime + '\'' +
                ", educate=" + educate +
                ", effect='" + effect + '\'' +
                ", summarize='" + summarize + '\'' +
                '}';
    }
}

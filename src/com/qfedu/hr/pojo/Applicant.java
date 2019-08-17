package com.qfedu.hr.pojo;

public class Applicant {
    private Integer id;
    private String name;
    private boolean gender;
    private Integer age;
    private String job;
    private String specialty;
    private String experience;
    private String studyEffort;
    private String school;
    private String tel;
    private String email;
    private String creatTime;
    private String content;
    private boolean hiring;

    public Applicant() {
    }

    public Applicant(Integer id, String name, boolean gender, Integer age, String job, String specialty, String experience, String studyEffort, String school, String tel, String email, String creatTime, String content, boolean hiring) {
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.job=job;
        this.specialty=specialty;
        this.experience=experience;
        this.studyEffort=studyEffort;
        this.school=school;
        this.tel=tel;
        this.email=email;
        this.creatTime=creatTime;
        this.content=content;
        this.hiring=hiring;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender=gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age=age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job=job;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty=specialty;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience=experience;
    }

    public String getStudyEffort() {
        return studyEffort;
    }

    public void setStudyEffort(String studyEffort) {
        this.studyEffort=studyEffort;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school=school;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel=tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime=creatTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content=content;
    }

    public boolean isHiring() {
        return hiring;
    }

    public void setHiring(boolean hiring) {
        this.hiring=hiring;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience='" + experience + '\'' +
                ", studyEffort='" + studyEffort + '\'' +
                ", school='" + school + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", content='" + content + '\'' +
                ", hiring=" + hiring +
                '}';
    }
}

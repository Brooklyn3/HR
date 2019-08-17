package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.AppLicantDao;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.utils.BaseDao;
import java.sql.SQLException;
import java.util.List;


public class AppLicitDagoImpl extends BaseDao implements AppLicantDao    {


    @Override
    public int addApplicant(Applicant applicant) throws SQLException {
        String sql = "insert into applicant(name,gender,age,job,specialty,experience," +
                "studyEffort,school,tel,email,createTime,content,Hiring) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object [] parameter = {applicant.getName(),
                applicant.isGender(),applicant.getAge(),
                applicant.getJob(),applicant.getSpecialty(),
                applicant.getExperience(),applicant.getStudyEffort(),
                applicant.getSchool(),applicant.getTel(),applicant.getEmail(),
                applicant.getCreatTime(),applicant.getContent(),applicant.isHiring()};
        return super.update(sql,parameter);

    }

    @Override
    public int deleteApplicant(int applicantid) throws SQLException {
        String sql = "delete  from applicant where id="+applicantid;
        return super.update(sql,null);
    }

    @Override
    public List<Applicant> findAll() throws SQLException {
        String sql = "select * from applicant";
        List<Applicant> query = super.query(sql,null,Applicant.class);
        return query;
    }

    @Override
    public int updateApplicant(Applicant applicant) throws SQLException {
        String sql = "update applicant set name=?,gender=?,age=?,job=?,specialty=?,experience=?," +
                "studyEffort=?,school=?,tel=?,email=?,createTime=?,content=?,Hiring=? where id=?";
        Object [] parameter = {applicant.getName(),
                applicant.isGender(),applicant.getAge(),applicant.getJob(),
                applicant.getSpecialty(),applicant.getExperience(),
                applicant.getStudyEffort(),applicant.getSchool(),applicant.getTel(),
                applicant.getEmail(),applicant.getCreatTime(),applicant.getContent(),
                applicant.isHiring(),applicant.getId()};
        return super.update(sql,parameter);
    }

    @Override
    public Applicant findById(int applicantId) throws SQLException {
        String sql = "select * from applicant where id="+applicantId;
        List<Applicant> query = super.query(sql,null,Applicant.class);
        return query != null ? query.get(0) : null;
    }
}

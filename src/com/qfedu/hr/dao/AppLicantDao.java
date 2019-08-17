package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Applicant;

import java.sql.SQLException;
import java.util.List;

public interface AppLicantDao {
    /**
     * 增加招聘人员的信息
     * @param applicant Applicant类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addApplicant(Applicant applicant) throws SQLException;

    /**
     * 修改招聘人员的信息
     * @param applicant Applicant类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateApplicant(Applicant applicant) throws SQLException;

    /**
     * 删除对应ID人员的招聘信息
     * @param applicantId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteApplicant(int applicantId) throws SQLException;

    /**
     * 展示所有的招聘人员信息
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Applicant> findAll() throws SQLException;

    /**
     * 根据ID进行相关的查询
     * @param applicantId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Applicant findById(int applicantId) throws SQLException;
}

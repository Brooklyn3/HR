package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Applicant;

import java.sql.SQLException;
import java.util.List;

public interface AppLicantService {
    /**
     *
     * @param applicant Applicant类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addApplicant(Applicant applicant) throws SQLException;

    /**
     *修改招聘人员信息
     * @param applicant Applicant类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateApplicant(Applicant applicant) throws SQLException;

    /**
     *删除ID对应的招聘信息
     * @param applicantId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteApplicant(int applicantId) throws SQLException;

    /**
     *展示所有招聘人员信息，管理员权限
     * @return 操作成功返回List集合包括Applicant对象，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Applicant> findAll() throws SQLException;

    /**
     * 查询ID对应信息
     * @param applicantId 员工ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Applicant findById(int applicantId) throws SQLException;
}

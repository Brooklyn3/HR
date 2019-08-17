package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalarySercice {
    /**
     *工资的添加
     * @param salary Salary类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addSalary(Salary salary) throws SQLException;

    /**
     * 工资的修改管理员权限
     * @param salary Salary类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  int updateSalary(Salary salary) throws SQLException;

    /**
     * 工资信息的修改
     * @param salaryId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int daleteSalary(int salaryId) throws SQLException;

    /**
     * 展示所有员工工资信息，管理员权限
     * @return  list集合包括Salary对象，找不到返回null
     * @throws SQLException SQL异常
     */
    public List<Salary> findAllSalary() throws SQLException;

    /**
     *根据员工的 ID展示相应的ID信息
     * @param salaryId 员工ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  Salary findById(int salaryId) throws SQLException;
}
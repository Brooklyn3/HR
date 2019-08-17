package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDao {
    /**
     * 增加员工工资信息
     * @param salary Salary类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addSalary(Salary salary) throws SQLException;
    /**
     * 修改员工工资信息
     * @param salary Salary类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateSalary(Salary salary) throws SQLException;

    /**
     * 删除员工工资信息
     * @param salaryId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteSalary(int salaryId) throws SQLException;

    /**
     * 展示所有的员工工资信息
     * @return 操作成功返回员工信息List集合，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Salary> findAllSalary() throws SQLException;

    /**
     * 用户传进来ID进行相关的查询
     * @param salaryId
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  Salary  findById(int salaryId) throws SQLException;

}

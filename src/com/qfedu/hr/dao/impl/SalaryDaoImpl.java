package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.SalaryDao;
import com.qfedu.hr.pojo.Salary;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class SalaryDaoImpl extends BaseDao implements SalaryDao {
    /**
     * 添加用户工资的信息，管理员权限
     * @param salary
     * @return
     * @throws SQLException
     */
    @Override
    public int addSalary(Salary salary) throws SQLException {
        String sql = "insert into salary(userId, basic, eat, house,  duty, scot, punishment, other,granTime, totalize) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Object[] parameters = {salary.getUserId(), salary.getBasic(), salary.getEat(), salary.getHouse(), salary.getDuty(), salary.getScot(),
                salary.getPunishment(), salary.getOther(), salary.getGranTime(),salary.getTotalize()};
        return super.update(sql, parameters);
    }

    /**
     * 修改用户的工资信息，管理员权限
     * @param salary
     * @return
     * @throws SQLException
     */
    @Override
    public int updateSalary(Salary salary) throws SQLException {
        String sql = "update hr.salary set userId = ?, basic = ?, eat = ?, house = ?, duty = ?,scot = ?, punishment = ?, other = ?,granTime = ?, totalize = ? where id = ?";
        Object[] parameters = {salary.getUserId(), salary.getBasic(), salary.getEat(), salary.getHouse(), salary.getDuty(), salary.getScot(),
                salary.getPunishment(), salary.getOther(), salary.getGranTime(), salary.getTotalize(),salary.getId()};
        return super.update(sql, parameters);
    }

    /**
     * 删除用户的工资信息，管理员权限
     * @param salaryId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteSalary(int salaryId) throws SQLException {
        String sql="delete  from salary where id="+salaryId;
        return super.update(sql,null);
    }

    /**
     * 查询用户的工资信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<Salary> findAllSalary() throws SQLException {
        String sql="select * from salary";
        List<Salary> query=super.query(sql, null, Salary.class);
        return query;
    }

    /**
     * 根据ID找到对应的工资信息
     * @param salaryId
     * @return
     * @throws SQLException
     */
    @Override
    public Salary findById(int salaryId) throws SQLException {
        String sql = "select * from salary where id= ?";
        Object[] parameters = {salaryId};
        List<Salary> query = super.query(sql, parameters, Salary.class);
        return query != null ? query.get(0) : null;
    }
}

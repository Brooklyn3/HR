package com.qfedu.hr.service.impl;
import com.qfedu.hr.dao.SalaryDao;
import com.qfedu.hr.dao.impl.SalaryDaoImpl;
import com.qfedu.hr.pojo.Salary;
import com.qfedu.hr.service.SalarySercice;
import java.sql.SQLException;
import java.util.List;

public class SalaryServiceimpl implements SalarySercice {
    //创建DAO层实例化对象
    SalaryDao salaryDao = new SalaryDaoImpl();

    /**
     * 工资的添加
     *
     * @param salary
     * @return
     * @throws SQLException
     */
    @Override
    public int addSalary(Salary salary) throws SQLException {
        return salaryDao.addSalary(salary);
    }

    /**
     * 工资的修改
     * @param salary
     * @return
     * @throws SQLException
     */
    @Override
    public int updateSalary(Salary salary) throws SQLException {
        return salaryDao.updateSalary(salary);
    }

    /**
     * 工资的删除
     * @param salaryId
     * @return
     * @throws SQLException
     */
    @Override
    public int daleteSalary(int salaryId) throws SQLException {
        return salaryDao.deleteSalary(salaryId);
    }

    /**
     *查询到所有工资信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<Salary> findAllSalary() throws SQLException {

        return salaryDao.findAllSalary();
    }

    @Override
    public Salary findById(int salaryId) throws SQLException {
        return salaryDao.findById(salaryId);
    }

}

package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Leave;
import java.sql.SQLException;
import java.util.List;

public interface LeaveService {
    /**
     *添加请假的信息
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addLeave(Leave leave) throws SQLException;

    /**
     *修改请假的信息
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateLeave(Leave leave) throws SQLException;

    /**
     *删除请假信息
     * @param leaveId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteLeave(int leaveId) throws SQLException;

    /**
     *展示所有的请假人员信息，管理员权限
     * @return 操作成功返回Leave对象的List信息集合，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Leave> findAll() throws SQLException;

    /**
     *通过ID找到对应的信息
     * @param leaveId 员工ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Leave findById(int leaveId) throws SQLException;

    /**
     *相应权限人员进行批假处理
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int ratify(Leave leave) throws SQLException;
}

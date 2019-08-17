package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Leave;

import java.sql.SQLException;
import java.util.List;

public interface LeaveDao {
    /**
     * 用户填写请假信息
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addLeave(Leave leave) throws SQLException;

    /**
     * 员工修改请假信息
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateLeave(Leave leave) throws SQLException;

    /**
     * 删除请假人信息，相关权限人员才能操作
     * @param leaveId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteLeave(int leaveId) throws SQLException;

    /**
     * 展示所有的请假人的信息，管理员权限
     * @return 操作成功返回请假List信息集合包含Leave对象，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Leave> findAll() throws SQLException;

    /**
     * 根据ID查询到的信息
     * @param leaveId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Leave findById(int leaveId) throws SQLException;

    /**
     * 相关权限人员进行批假
     * @param leave Leave类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int ratify(Leave leave) throws SQLException;

}

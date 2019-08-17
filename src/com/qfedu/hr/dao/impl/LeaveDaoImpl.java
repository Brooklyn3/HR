package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.LeaveDao;
import com.qfedu.hr.pojo.Leave;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class LeaveDaoImpl extends BaseDao implements LeaveDao {
    @Override
    public int addLeave(Leave leave) throws SQLException {
        String sql = "insert into hr.leaving(userName, beginTime, endTime, reasons, conditioning) VALUES (?,?,?,?,?)";
        Object [] parameter ={leave.getUserName(),leave.getBeginTime(),leave.getEndTime(),leave.getReasons(),leave.getConditioning()};
        return super.update(sql,parameter);
    }

    @Override
    public int updateLeave(Leave leave) throws SQLException {
        String sql = "update leaving set userName=?, beginTime=?, endTime=?, reasons=?, conditioning=? where id=?";
        Object [] parameter = {leave.getUserName(),leave.getBeginTime(),leave.getEndTime(),leave.getReasons(),leave.getConditioning(),leave.getId()};
        return super.update(sql,parameter);
    }

    @Override
    public int deleteLeave(int leaveId) throws SQLException {
        String sql = "delete from leaving where id = "+leaveId;
        return super.update(sql,null);
    }

    @Override
    public List<Leave> findAll() throws SQLException {
        String sql = "select * from leaving";
        List<Leave> query = super.query(sql,null,Leave.class);
        return query;
    }

    @Override
    public Leave findById(int leaveId) throws SQLException {
        String sql = "select * from leaving where id = "+leaveId;
        List<Leave> query = super.query(sql,null,Leave.class);
        return query != null ? query.get(0) : null;
    }

    @Override
    public int ratify(Leave leave) throws SQLException {
        String sql = "update leaving set conditioning='已通过' where id=?";
        Object [] parameter ={leave.getId()};
        return super.update(sql,parameter);
    }
}

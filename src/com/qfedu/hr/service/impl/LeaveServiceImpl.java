package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.LeaveDao;
import com.qfedu.hr.dao.impl.LeaveDaoImpl;
import com.qfedu.hr.pojo.Leave;
import com.qfedu.hr.service.LeaveService;

import java.sql.SQLException;
import java.util.List;

public class LeaveServiceImpl implements LeaveService {
    //DAO层实例化对象
    private LeaveDao leaveDao = new LeaveDaoImpl();
    @Override
    public int addLeave(Leave leave) throws SQLException {
        return leaveDao.addLeave(leave);
    }

    @Override
    public int updateLeave(Leave leave) throws SQLException {
        return leaveDao.updateLeave(leave);
    }

    @Override
    public int deleteLeave(int leaveId) throws SQLException {
        return leaveDao.deleteLeave(leaveId);
    }

    @Override
    public List<Leave> findAll() throws SQLException {
        return leaveDao.findAll();
    }

    @Override
    public Leave findById(int leaveId) throws SQLException {
        return leaveDao.findById(leaveId);
    }

    @Override
    public int ratify(Leave leave) throws SQLException {
        return leaveDao.ratify(leave);
    }
}

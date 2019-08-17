package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.AppLicantDao;
import com.qfedu.hr.dao.impl.AppLicitDagoImpl;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.service.AppLicantService;

import java.sql.SQLException;
import java.util.List;

public class AppLicantServiceImpl implements AppLicantService {
    //创建AppLicantDao实例化对象，调用DAO中的方法
    private AppLicantDao appLicantDao = new AppLicitDagoImpl();

    @Override
    public int addApplicant(Applicant applicant) throws SQLException {
        return appLicantDao.addApplicant(applicant);
    }
    @Override
    public  int updateApplicant(Applicant applicant) throws SQLException {
        return appLicantDao.updateApplicant(applicant);
    }

    @Override
    public int deleteApplicant(int applicantId) throws SQLException {
        return appLicantDao.deleteApplicant(applicantId);
    }

    @Override
    public List<Applicant> findAll() throws SQLException {
        return appLicantDao.findAll();
    }

    @Override
    public Applicant findById(int applicantId) throws SQLException {
        return appLicantDao.findById(applicantId);
    }
}

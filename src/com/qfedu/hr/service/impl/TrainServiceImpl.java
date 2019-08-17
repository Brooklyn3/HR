package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.TrainDao;
import com.qfedu.hr.dao.impl.TrainDaoImpl;
import com.qfedu.hr.pojo.Train;
import com.qfedu.hr.service.TrainService;

import java.sql.SQLException;
import java.util.List;

public class TrainServiceImpl implements TrainService {
    TrainDao trainDao = new TrainDaoImpl();
    /**
     * 添加课程的信息,通过Train对象，借助于TrainDao操作数据库
     *
     * @param train Train对象
     * @return 返回影响数据库的行数
     * @throws SQLException
     */
    @Override
    public int addTrain(Train train) throws SQLException {
        return trainDao.addTrain(train);
    }

    /**
     * 删除相关人员的课程的信息，通过Train，借助于TrainDao层操作数据库
     *
     * @param trainId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteTrain(int trainId) throws SQLException {
        return trainDao.deleteTrain(trainId);
    }

    @Override
    public int updateTrain(Train train) throws SQLException {
        return trainDao.updateTrain(train);
    }

    @Override
    public List<Train> findAllTrain() throws SQLException {
        return trainDao.findAllTrain();
    }

    @Override
    public Train findById(int trainId) throws SQLException {
        return trainDao.findById(trainId);
    }
}

package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainService {
    /**
     * 添加课程的信息,通过Train对象，借助于TrainDao操作数据库
     * @param train Train类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addTrain(Train train) throws SQLException;

    /**
     * 删除相关人员的课程的信息，通过Train，借助于TrainDao层操作数据库
     * @param trainId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  int deleteTrain(int trainId) throws SQLException;

    /**
     * 修改参加课程人员信息
     * @param train Train类对象
     * @return 查询Train的List信息集合，找不到返回null
     * @throws SQLException SQL异常
     */
    public int updateTrain (Train train) throws SQLException;

    /**
     * 展示所有参加培训人员信息
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Train> findAllTrain () throws SQLException;

    /**
     *根据员工Id号查询员工的信息
     * @param trainId 员工ID号
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Train findById(int trainId) throws SQLException;
}

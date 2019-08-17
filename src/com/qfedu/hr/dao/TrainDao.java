package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainDao {
    /**
     * 增加培训课程人员信息，管理员权限
     * @param train Train类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addTrain(Train train) throws SQLException;
    /**
     * 修改培训课程人员信息，管理员权限
     * @param train Train类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int updateTrain (Train train) throws SQLException;

    /**
     * 删除培训人员的信息
     * @param trainId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  int deleteTrain(int trainId) throws SQLException;

    /**
     * 展示所有培训人员的信息
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public List<Train> findAllTrain () throws SQLException;

    /**
     * 根据ID进行相关的查询
     * @param trainId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public Train findById(int trainId) throws SQLException;
}

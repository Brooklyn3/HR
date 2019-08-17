package com.qfedu.hr.dao.impl;
import com.qfedu.hr.dao.TrainDao;
import com.qfedu.hr.pojo.Train;
import com.qfedu.hr.utils.BaseDao;
import java.sql.SQLException;
import java.util.List;

public class TrainDaoImpl extends BaseDao implements TrainDao {
    /**
     * 增加培训课程
     * @param train Train类对象
     * @return
     * @throws SQLException
     */
    @Override
    public int addTrain(Train train) throws SQLException {
        String sql = "insert into train(name, purpose, beginTime, endTime, datum, teacher," +
                " studentId, createTime, educate, effect, summarize) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] parameters = {train.getName(), train.getPurpose(), train.getBeginTime(),
                train.getEndTime(), train.getDatum(), train.getTeacher(),
                train.getStudentId(), train.getCreateTime(),train.isEducate(), train.getEffect(), train.getSummarize()};
        return super.update(sql,parameters);
    }

    /**
     * 删除培训课程信息
     * @param trainId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteTrain(int trainId) throws SQLException {
        String sql = "delete  from train where id=" +trainId;
        return super.update(sql,null);
    }

    /**
     * 修改培训课程信息
     * @param train Train对象
     * @return
     * @throws SQLException
     */
    @Override
    public int updateTrain(Train train) throws SQLException {
        String sql = "update hr.train set name = ?, purpose = ?, beginTime = ?, endTime = ?, datum = ?, teacher = ?, studentId = ?, createTime = ?, educate = ?, effect = ?, summarize = ? where id = ?";
        Object[] parameters = {train.getName(), train.getPurpose(), train.getBeginTime(), train.getEndTime(), train.getDatum(), train.getTeacher(),
                train.getStudentId(), train.getCreateTime(), train.isEducate(),train.getEffect(), train.getSummarize(),train.getId()};
        return super.update(sql, parameters);}

    /**
     * 查询到所有培训课程信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<Train> findAllTrain() throws SQLException {
        String sql = "select * from train";
        List<Train> query = super.query(sql,null,Train.class);
        return query;
    }

    /**
     * 根据Id找到对应的课程信息
     * @param trainId 用户传进来的ID
     * @return
     * @throws SQLException
     */
    @Override
    public Train findById(int trainId) throws SQLException {
        String sql = "select * from hr.train where id = " + trainId;
        List<Train> query = super.query(sql, null, Train.class);
        return query.get(0);
    }
}

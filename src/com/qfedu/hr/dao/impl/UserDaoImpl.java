package com.qfedu.hr.dao.impl;


import com.qfedu.hr.dao.UserDao;
import com.qfedu.hr.pojo.User;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 判定request传入的用户名和密码是否和数据中保存的数据是否一致
     *
     * @param userName
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public User findUserByUserNameAndPassword(String userName, String password) throws SQLException {
        String sql="select * from user where userName = ? and password =?";
        Object[] parameters={userName, password};
        List<User> query=super.query(sql, parameters, User.class);

        return query != null ? query.get(0) : null;
    }

    /**
     * 用户的添加，管理员权限
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into user(userName, password, gender, birthday, createTime, content, roleId) values (?,?,?,?,?,?,?)";
        Object[] parameters = {user.getUserName(), user.getPassword(),
                user.isGender(), user.getBirthday(), user.getCreateTime(),
                user.getContent(), user.getRoleId()};
        return super.update(sql, parameters);
    }

    /**
     * 找到所有的用户信息集合
     * @return影响数据库的行数
     * @throws SQLException
     */
    @Override
    public List<User> findAllUserList() throws SQLException {
        String sql="select * from user";
        List<User> query=super.query(sql, null, User.class);
        return query;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int updateUser(User user) throws SQLException {
        String sql="update user set userName=?, password=?, gender=?, birthday=?, createTime=?, content=?,roleId=? where id=?";
        Object[] parameters={user.getUserName(), user.getPassword(),
                user.isGender(), user.getBirthday(), user.getCreateTime(),
                user.getContent(), user.getRoleId(), user.getId()};
        return super.update(sql,parameters);
    }

    /**
     *找到指定用户ID信息
     * @param userId
     * @return
     * @throws SQLException
     */
    @Override
    public User findById(int userId) throws SQLException {
        String sql = "select * from user where id =" +userId;
        List<User> query = super.query(sql, null, User.class);
        return query != null ? query.get(0) : null;
    }

    /**
     * 删除用户的信息，管理员权限
     * @param userId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteUser(int userId) throws SQLException {
        String sql = "delete  from user where id = " + userId;
        return super.update(sql, null);
    }

}
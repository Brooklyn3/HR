package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.UserDao;

import com.qfedu.hr.dao.impl.UserDaoImpl;
import com.qfedu.hr.pojo.User;
import com.qfedu.hr.service.UserService;

import java.sql.SQLException;
import java.util.List;

public  class UserServiceImpl implements UserService {
    //创建UserDao接口实例化对象
    UserDao userDao = new UserDaoImpl();

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) throws SQLException {
        return userDao.findUserByUserNameAndPassword(userName,password);
    }

    /**
     * 通过User对象 借助于UserDao操作数据库
     *
     * @param user User类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException
     */
    @Override
    public int saveUser(User user) throws SQLException {
        return userDao.addUser(user);
    }


    /**
     * 找到所有的员工信息 通过User对象 借助于UserDao操作数据ku
     * @return 展示所有信息
     * @throws SQLException
     */
    @Override
    public List<User> findAllUserList() throws SQLException {
        return userDao.findAllUserList();
    }

    /**
     * 借助于User对象， 借助于UserDao操作数据库
     *
     * @param user User类对象
     * @return 操作成功后返回修改的数据库语句  没成功返回null
     */
    @Override
    public int updateUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }

    @Override
    public User findById(int userId) throws SQLException {
        return userDao.findById(userId);
    }

    @Override
    public int deleteUser(int userId) throws SQLException {
        return userDao.deleteUser(userId);
    }

}

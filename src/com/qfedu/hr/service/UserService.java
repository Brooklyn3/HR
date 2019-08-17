package com.qfedu.hr.service;

import com.qfedu.hr.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    /**
     * 通过用户名userName和password借助于 UeserDao操作数据库
     * @param userName 用户名
     * @param password 密码
     * @return 在数据库中找到 User对象 找不到返回null
     * @throws SQLException
     */
    public  User findUserByUserNameAndPassword(String userName, String password) throws SQLException;

    /**
     *通过User对象 借助于UserDao操作数据库
     * @param user User类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException
     */
    public int saveUser(User user) throws SQLException;

    /**
     * 展示所有信息 通过User对象集合 借助于UserDao操作数据库
     * @return ListUser所有信息集合 包括User对象 失败返回null
     * @throws SQLException
     */
    public List<User> findAllUserList() throws SQLException;

    /**
     * 修改员工信息 借助于User对象， 借助于UserDao操作数据库
     * @param user User类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     */
    public int updateUser(User user) throws SQLException;

    /**
     * 找到ID对应的信息
     * @param userId User ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  User findById(int userId) throws SQLException;

    /**
     * 删除ID对应的信息
     * @param userId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteUser(int userId) throws SQLException;

}

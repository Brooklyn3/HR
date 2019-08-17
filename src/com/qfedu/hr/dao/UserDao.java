package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * 判断用户输入的用户名对应的密码是否正确
     * @param userName 用户传进来的用户名
     * @param password 用户传进来的密码
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public User findUserByUserNameAndPassword(String userName, String password) throws SQLException;

    /**
     * 管理员权限，增加用户
     * @param user User类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int addUser(User user) throws SQLException;

    /**
     *展示所有员工
     * @return 操作成功返回List集合里面包含User对象，失败返回null
     * @throws SQLException SQL异常
     */
    public List<User> findAllUserList() throws SQLException;

    /**
     * 对员工信息进行修改
     * @param user User类对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  int updateUser(User user) throws SQLException;

    /**
     * 找到ID对应的信息
     * @param userId 用户输入的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public  User findById(int userId) throws SQLException;

    /**
     * 管理员权限删除员工
     * @param userId 用户传进来的ID
     * @return 操作成功返回影响数据库的行数，失败返回null
     * @throws SQLException SQL异常
     */
    public int deleteUser (int userId) throws SQLException;


}

package com.qfedu.hr.servlet;


import com.qfedu.hr.pojo.User;
import com.qfedu.hr.service.UserService;
import com.qfedu.hr.service.impl.UserServiceImpl;
import com.qfedu.hr.utils.BaseServlet;
import com.qfedu.hr.utils.MessageRequest;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
    /**
     * UserServlet对应的Servlet层实现类对象，用户处理内容，执行Dao层
     */
    private UserService userService =new UserServiceImpl();
    public  void userServlet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取用户通过前端页面提交的userName和password
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userService.findUserByUserNameAndPassword(userName, password);
            if (null == user) {
                // 调用异常信息转发工具类中的方法，转发异常信息到指定的资源中
                MessageRequest.messageRequestDispatcher(response, request, "用户名或者密码错误", "login.jsp");
            } else {
                // 保存当前 User类对象到 Session域对象中
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "登录失败", "login.jsp");
        }
    }

    /**
     * 用户退出操作，在需要在top.jsp页面上留有链接
     * @param response HTTPServletRequest 用户请求HTTP对象
     * @param request HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws IOException
     */
  public void userLogout(HttpServletResponse response,HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("login.jsp");
  }
    /**
     * 管理员权限 跳转到add.jsp页面进行
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     */
  public void toAddUserJsp(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("addUser.jsp").forward(request,response);
  }
    /**
     * 管理员权限 跳转到ListUser.jsp页面
     * @param response  HTTPServletRequest 用户请求HTTP对象
     * @param request  HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ServletException
     * @throws IOException
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException, ParseException, SQLException {
        //获取输入的用户信息
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装 User类对象
        User user = new User();
        BeanUtils.populate(user, parameterMap);
        try {
            //调用UserService中的addUse方法进行添加数据
            userService.saveUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "添加失败", "listUser.jsp");
        }
        List<User> allUserList=userService.findAllUserList();
        request.setAttribute("allUserList",allUserList);
        MessageRequest.messageRequestDispatcher(response, request, "添加成功", "listUser.jsp");
    }
    /**
     * 管理员权限展示所有员工信息 跳转到 listUser.jsp页面
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws SQLException
     */
  public void userList(HttpServletRequest request,HttpServletResponse response) throws SQLException {
      //调用userService层中的方法
      List<User> allUserList =userService.findAllUserList();
      request.setAttribute("allUserList",allUserList);
      try {
          for (User user : allUserList) {
              System.out.println(user);
          }
          request.getRequestDispatcher("listUser.jsp").forward(request,response);
      } catch (ServletException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
    /**
     * 修改员工信息 借助于User对象， 借助于UserDao操作数据库
     * @param request HTTPServletResponse 服务器请求HTTP协议响应对象
     * @param response HTTPServletRequest 用户请求HTTP对象
     * @return 操作成功返回影响数据库的行数，失败返回null
     */
  public void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException, SQLException {
      //获取到输入的信息
      Map<String, String[]> parameterMap = request.getParameterMap();
      User user = new User();
      BeanUtils.populate(user, parameterMap);
      try {
          //调用userService中的updateUser方法对员工进行修改
          userService.updateUser(user);
      } catch (SQLException e) {
          e.printStackTrace();
          MessageRequest.messageRequestDispatcher(response, request, "修改失败", "aaa.jsp");
      }
      List<User> allUserList=userService.findAllUserList();
      request.setAttribute("allUserList",allUserList);
      request.getRequestDispatcher("listUser.jsp").forward(request,response);
  }

    /**
     * 查询一个员工id对应的信息
     * @param response   HTTPServletRequest 用户请求HTTP对象
     * @param request   HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
  public void findOne(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
      //获取输入的id
      Integer id = Integer.valueOf(request.getParameter("id"));
      User user = userService.findById(id);
      //对获取到的信息进行判断，进行相应的转发
      if (null == user) {
          MessageRequest.messageRequestDispatcher(response, request, "对应的员工不存在", "aaa.jsp");
      } else {
          request.setAttribute("user", user);
          request.getRequestDispatcher("update.jsp").forward(request, response);
      }
  }

    /**
     * 删除人员，管理员权限
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     */
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //获取输入的id
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            userService.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "删除失败", "Jumpfailure.jsp");
        }
        List<User> allUserList=userService.findAllUserList();
        request.setAttribute("allUserList",allUserList);
        request.getRequestDispatcher("listUser.jsp").forward(request,response);
    }
}

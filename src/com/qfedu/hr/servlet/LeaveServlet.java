package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.Leave;
import com.qfedu.hr.service.LeaveService;
import com.qfedu.hr.service.impl.LeaveServiceImpl;
import com.qfedu.hr.utils.BaseServlet;
import com.qfedu.hr.utils.MessageRequest;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import static java.lang.Integer.valueOf;

@WebServlet("/LeaveServlet")
public class LeaveServlet extends BaseServlet {
    private LeaveService leaveService = new LeaveServiceImpl();

    /**
     * 用户请假
     * @param request HttpServletRequest用户的请求
     * @param response HttpServletResponse服务器给予用户的响应
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 安全异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void addLeave(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        Map<String, String[]> leaveMap=request.getParameterMap();
        Leave leave=new Leave();
        BeanUtils.populate(leave,leaveMap);
        leave.setConditioning("等待审批ing...");
        try {
            leaveService.addLeave(leave);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"","Jumpfailcant.jsp");
        }
        List<Leave> all=leaveService.findAll();
        request.setAttribute("leaves",all);
        MessageRequest.messageRequestDispatcher(response,request,"添加成功","listLeave.jsp");
    }

    /**
     * 用户修改请假原因
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 安全异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
        public void updateLeave(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
            Map<String, String[]> parameterMap=request.getParameterMap();
            Leave leave=new Leave();
            BeanUtils.populate(leave, parameterMap);
            try {
                leaveService.updateLeave(leave);
            } catch (SQLException e) {
                e.printStackTrace();
                MessageRequest.messageRequestDispatcher(response,request,"修改失败","Jumpfailure.jsp");
            }
            List<Leave> all=leaveService.findAll();
            request.setAttribute("leaves",all);
            MessageRequest.messageRequestDispatcher(response,request,"添加成功","listLeave.jsp");
        }

    /**
     * 删除相关请假人员信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void deleteLeave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer id = valueOf(request.getParameter("id"));
        try {
            leaveService.deleteLeave(id);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"删除失败","");
        }
        List<Leave> all=leaveService.findAll();
        request.setAttribute("leaves",all);
        request.getRequestDispatcher("listLeave.jsp").forward(request,response);
    }

    /**
     * 所有请假人员信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     * @throws SQLException SQL异常
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Leave> leaves = leaveService.findAll();
        request.setAttribute("leaves",leaves);
        request.getRequestDispatcher("listLeave.jsp").forward(request,response);
    }

    /**
     * 根据ID找到相关的信息
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     * @throws SQLException SQL异常
     */
    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Leave leave = leaveService.findById(id);
        if (null == leave) {
            MessageRequest.messageRequestDispatcher(response, request, "没有找到id对应的信息", "");
        } else {
            request.setAttribute("leave",leave);
            request.getRequestDispatcher("updateLeave.jsp").forward(request,response);
        }
    }

    /**
     * 相关权限的人员进行批假
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 安全异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void ratify(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        Map<String,String []> parameterMap = request.getParameterMap();
        Leave leave=new Leave();
        BeanUtils.populate(leave,parameterMap);
        try {
            leaveService.ratify(leave);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"审批失败","");
        }
        List<Leave> all=leaveService.findAll();
        request.setAttribute("leaves",all);
        request.getRequestDispatcher("listLeave.jsp").forward(request,response);
    }
}

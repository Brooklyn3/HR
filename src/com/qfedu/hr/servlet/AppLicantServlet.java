package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.service.AppLicantService;
import com.qfedu.hr.service.impl.AppLicantServiceImpl;
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
@WebServlet("/AppLicantServlet")
public class AppLicantServlet extends BaseServlet {
    //SalaryService对应的Service实现类对象，用于处理服务内容，执行Dao层
    private AppLicantService appLicantService = new AppLicantServiceImpl();
    /**
     * 增加招聘人员信息
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 安全异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void addAppLicant( HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        Map<String,String[]> applicantMap = request.getParameterMap();
        Applicant applicant = new Applicant();
        BeanUtils.populate(applicant,  applicantMap);
        try {
            appLicantService.addApplicant(applicant);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"添加失败","Jumpfailure.jsp");
        }
        List<Applicant> all=appLicantService.findAll();
        request.setAttribute("applicants",all);
        MessageRequest.messageRequestDispatcher(response,request,"添加成功","listAppLicant.jsp");
    }

    /**
     * 修改ID对应相关人员的招聘信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 安全异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public  void updateAppLicant(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        Map<String,String[]> applicantMap = request.getParameterMap();
        Applicant applicant = new Applicant();
        BeanUtils.populate(applicant,applicantMap);
        try {
            appLicantService.updateApplicant(applicant);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"失败","Jumpfailure.jsp");
        }
        List<Applicant> all=appLicantService.findAll();
        request.setAttribute("applicants",all);
        request.getRequestDispatcher("listAppLicant.jsp").forward(request,response);
    }

    /**
     * 删除ID对应人员的招聘信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws IOException IO异常
     * @throws ServletException servlet异常
     */
    public void deleteAppLicant(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, SQLException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            appLicantService.deleteApplicant(id);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"","");
        }
        List<Applicant> all=appLicantService.findAll();
        request.setAttribute("applicants",all);
        request.getRequestDispatcher("listAppLicant.jsp").forward(request,response);
    }

    /**
     * 展示所有招聘人员信息
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws SQLException SQL异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Applicant> applicants = appLicantService.findAll();
        for (Applicant applicant : applicants) {
            System.out.println(applicant);
        }
        request.setAttribute("applicants",applicants);
        request.getRequestDispatcher("listAppLicant.jsp").forward(request,response);
    }

    /**
     * 找到ID对应的信息
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void findById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            Applicant applicant = appLicantService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response,request,"没有找到该ID对应的信息","Jumpfailure.jsp");
        }
        request.getRequestDispatcher("updateApplicant.jsp").forward(request,response);
    }
}

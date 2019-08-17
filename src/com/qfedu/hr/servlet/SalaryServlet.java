package com.qfedu.hr.servlet;


import com.qfedu.hr.pojo.Salary;
import com.qfedu.hr.service.SalarySercice;
import com.qfedu.hr.service.impl.SalaryServiceimpl;
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

@WebServlet("/SalaryServlet")
public class SalaryServlet extends BaseServlet {
    //创建Salary Service实例化对象，依据层级关系
    private SalarySercice salarySercice=new SalaryServiceimpl();

    /**
     * 管理员权限 跳转到工资添加界面
     *
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     */
    public void toAddSalaryJsp(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher("addSalarry.jsp").forward(request, response);
    }

    /**
     * 管理员权限 人员工资的增加
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ServletException
     * @throws IOException
     */
    public void addSalary(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IOException, IllegalAccessException, ServletException, SQLException {
        Map<String, String[]> stringMap=request.getParameterMap();
        Salary salary=new Salary();
        BeanUtils.populate(salary, stringMap);
        try {
            salarySercice.addSalary(salary);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "添加失败", "Jumpfailure.jsp");
        }
        List<Salary> allSalary=salarySercice.findAllSalary();
        request.setAttribute("salary",allSalary);
        request.getRequestDispatcher("salaryList.jsp").forward(request,response);
    }

    /**
     * 相关人员工资修改，管理员权限
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     */
    public void updateSalary(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException, SQLException {
        //获取输入的值
        Map<String, String[]> parameterMap=request.getParameterMap();
        //封装Salary类对象
        Salary salary=new Salary();
        BeanUtils.populate(salary, parameterMap);
        try {
            //调用salaryService层方法
            salarySercice.updateSalary(salary);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "修改失败", "Jumpfailure.jsp");
        }
        List<Salary> allSalary=salarySercice.findAllSalary();
        request.setAttribute("salary",allSalary);
        request.getRequestDispatcher("salaryList.jsp").forward(request,response);
        request.getRequestDispatcher("listApplicant.jsp").forward(request,response);

    }
    /**
     * 相关人员的工资信息的删除，管理员权限
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ServletException
     * @throws IOException
     */
    public void daleteSalary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer id=Integer.valueOf(request.getParameter("id"));
        try {
            salarySercice.daleteSalary(id);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "删除失败", "Jumpfailure.jsp");
        }

        List<Salary> allSalary=salarySercice.findAllSalary();
        request.setAttribute("salary",allSalary);
        request.getRequestDispatcher("salaryList.jsp").forward(request,response);
    }


    /**
     * 查询到所有员工工资表信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws SQLException
     */
    public void findAllSalary(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Salary> allSalary=salarySercice.findAllSalary();
        request.setAttribute("salary", allSalary);
        request.getRequestDispatcher("salaryList.jsp").forward(request, response);

    }
    /**
     * 找到需要的查询的Id相关人员的信息
     * @param request HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void findById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //获取输入的Id
        Integer id=Integer.valueOf(request.getParameter("id"));
        //调用salaryService层中的方法在数据库中找到对应的Id
        Salary salary=salarySercice.findById(id);
        //对在数据库找到的数据进行判断，在进行对应的转发
        if (null == salary) {
            MessageRequest.messageRequestDispatcher(response, request, "没有找到", "Jumpfailure.jsp");
        } else {
            request.setAttribute("salary",salary);
           request.getRequestDispatcher("updateSalary.jsp").forward(request,response);
        }
    }
}

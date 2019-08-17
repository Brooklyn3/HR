package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.Train;
import com.qfedu.hr.service.TrainService;
import com.qfedu.hr.service.impl.TrainServiceImpl;
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
@WebServlet("/TrainServlet")
public class TrainServlet extends BaseServlet {
    //创建TrainService实例化对象，调用DAO层方法
    private TrainService trainService=new TrainServiceImpl();

    /**
     * 添加培训课程，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException    安全权限异常
     * @throws ServletException          servlet异常
     * @throws IOException               IO异常
     */
    public void addTrain(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        //获取输入信息
        Map<String, String[]> parameterMap=request.getParameterMap();
        Train train=new Train();
        BeanUtils.populate(train, parameterMap);
        try {
            trainService.addTrain(train);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "添加失败", "");
        }
        List<Train> allTrain=trainService.findAllTrain();
        request.setAttribute("train",allTrain);
        request.getRequestDispatcher("trainList.jsp").forward(request, response);
    }

    /**
     * 修改培训信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException    安全权限异常
     * @throws ServletException          servlet异常
     * @throws IOException               IO异常
     */
    public void updateTrain(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException, SQLException {
        //获取用户输入的信息
        Map<String, String[]> parameter=request.getParameterMap();
        Train train=new Train();
        BeanUtils.populate(train, parameter);
        try {
            trainService.updateTrain(train);
        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "删除失败", "Jumpfailre.jsp");
        }
        List<Train> allTrain=trainService.findAllTrain();
        request.setAttribute("train",allTrain);
        request.getRequestDispatcher("trainList.jsp").forward(request, response);
    }

    /**
     * 展示所有员工的培训信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     * @throws SQLException     SQL异常
     */
    public void findAll(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException, SQLException {
        List<Train> trains=trainService.findAllTrain();
        request.setAttribute("train", trains);
        request.getRequestDispatcher("trainList.jsp").forward(request, response);
    }

    /**
     * 删除相关人员的培训信息，管理员权限
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws ServletException
     * @throws IOException
     */
    public void deleteTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer id=Integer.valueOf(request.getParameter("id"));
        try {
            trainService.deleteTrain(id);

        } catch (SQLException e) {
            e.printStackTrace();
            MessageRequest.messageRequestDispatcher(response, request, "删除失败", "Jumpfailre.jsp");
        }
        List<Train> allTrain=trainService.findAllTrain();
        request.setAttribute("train",allTrain);
        request.getRequestDispatcher("trainList.jsp").forward(request, response);
    }

    /**
     * 根据ID查询到对应的ID信息
     * @param request  HTTPServletRequest 用户请求HTTP对象
     * @param response HTTPServletResponse 服务器请求HTTP协议响应对象
     * @throws SQLException SQl异常
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    public void findById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //获取用户修改的信息
        Integer id=Integer.valueOf(request.getParameter("id"));
        Train train=trainService.findById(id);
        //对所获取的id信息进行判断进行对应得处理
        if (null == train) {
            MessageRequest.messageRequestDispatcher(response, request, "找不到Id对应的信息", "xxx");
        } else {
            request.setAttribute("train",train);
            request.getRequestDispatcher("updateTrain.jsp").forward(request, response);
        }
    }
}

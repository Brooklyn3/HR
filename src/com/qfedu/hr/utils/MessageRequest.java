package com.qfedu.hr.utils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageRequest {
    public static void messageRequestDispatcher(HttpServletResponse response, HttpServletRequest request,String msg,String path) throws ServletException, IOException {
        request.setAttribute("msg",msg);
        request.getRequestDispatcher(path).forward(request,response);
    }

}

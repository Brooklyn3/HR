<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/9
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<h3 align="center">培训课程列表</h3>
<table align="center">
    <tr>
        <th>课程名称</th>
        <th>培训目的</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>培训材料</th>
        <th>讲师</th>
        <th>培训人ID</th>
        <th>创建时间</th>
        <th>是否完成</th>
        <th>培训效果</th>
        <th>培训总能感觉</th>
        <th>操作</th>
    </tr>
    <c:if test="${train != null}">
        <c:forEach items="${train}" var="msg">
            <tr>
                <td>${msg.name}</td>
                <td>${msg.purpose}</td>
                <td>${msg.beginTime}</td>
                <td>${msg.endTime}</td>
                <td>${msg.datum}</td>
                <td>${msg.teacher}</td>
                <td>${msg.studentId}</td>
                <td>${msg.createTime}</td>
                <td>${msg.educate}</td>
                <td>${msg.effect}</td>
                <td>${msg.summarize}</td>
                <td>
                    <a href="TrainServlet?method=findById&id=${msg.id}">修改</a>
                    <a href="TrainServlet?method=deleteTrain&id=${msg.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>

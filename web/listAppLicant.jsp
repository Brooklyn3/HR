<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/10
  Time: 9:35
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
    <style type="text/css">
        body{
            background-image: url("images/u=1606974046,3479207604&fm=11&gp=0.jpg");

        }
    </style>
</head>
<body>
<a href="addAppLicant.jsp">添加招聘人员</a>
<h4 align="center">招聘管理</h4>
<table border="1px" width="600px" align="center">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>岗位</th>
        <th>专业</th>
        <th>工作经验</th>
        <th>学历</th>
        <th>毕业学校</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>登记时间</th>
        <th>详细经历</th>
    </tr>
    <c:if test="${applicants != null}">
        <c:forEach items="${applicants}" var="app">
            <tr>
                <td>${app.name}</td>
                <td>
                    <c:if test="${!app.gender}">男</c:if>
                    <c:if test="${app.gender}">女</c:if>
                </td>
                <td>${app.age}</td>
                <td>${app.job}</td>
                <td>${app.specialty}</td>
                <td>${app.experience}</td>
                <td>${app.studyEffort}</td>
                <td>${app.school}</td>
                <td>${app.tel}</td>
                <td>${app.email}</td>
                <td>${app.content}</td>

                <td>
                    <a href="AppLicantServlet?method=findById&id=${app.id}">修改</a>
                    <a href="AppLicantServlet?method=deleteAppLicant&id=${app.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>

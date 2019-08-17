<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <title>所有员工信息</title>
    <style type="text/css">
        body {
            background-image: url("images/u=2457305625,2231421459&fm=26&gp=0.jpg");
        }
    </style>
</head>
<body>
<h1 align="center">员工信息</h1>
<div>
    <table border="1px" align="center">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>性别</th>
            <th>生日</th>
            <th>入职时间</th>
            <th>自我简述</th>
            <th>角色ID</th>
            <th>操作</th>
        </tr>
        <c:if test="${allUserList != null}">
        <c:forEach items="${allUserList}" var="allUserList" varStatus="e">
        <tr>
            <td>${allUserList.id}</td>
            <td>${allUserList.userName}</td>
            <td>${allUserList.password}</td>
            <td>
                <c:if test="${!allUserList.gender}">男</c:if>
                <c:if test="${allUserList.gender}">女</c:if>
            </td>
            <td>${allUserList.birthday}</td>
            <td>${allUserList.createTime}</td>
            <td>${allUserList.content}</td>
            <td>${allUserList.roleId}</td>
            <td>
                <a href="LoginServlet?method=findOne&id=${allUserList.id}">修改</a>
                <a href="LoginServlet?method=deleteUser&id=${allUserList.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
        </c:if>
</div>
</table>
</body>
</html>

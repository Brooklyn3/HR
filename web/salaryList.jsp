<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/5
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <title>工资表</title>

</head>
<body>
<h1 align="center">工资信息</h1>
<table border="1px" width="600px" align="center">
    <tr>
        <th>员工ID</th>
        <th>基本薪资</th>
        <th>饭补</th>
        <th>住房补贴</th>
        <th>全勤奖</th>
        <th>扣税</th>
        <th>罚款</th>
        <th>其他补助</th>
        <th>发放时间</th>
        <th>操作</th>

    </tr>
    <c:if test="${salary != null}">
        <c:forEach items="${salary}" var="salary">
            <tr>
                <td>${salary.userId}</td>
                <td>${salary.basic}</td>
                <td>${salary.eat}</td>
                <td>${salary.house}</td>
                <td>${salary.duty}</td>
                <td>${salary.scot}</td>
                <td>${salary.punishment}</td>
                <td>${salary.other}</td>
                <td>${salary.granTime}</td>
                <td>
                    <a href="SalaryServlet?method=findById&id=${salary.id}">修改</a>
                    <a href="SalaryServlet?method=daleteSalary&id=${salary.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>

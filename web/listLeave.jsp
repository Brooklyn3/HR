<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/12
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <title >Title</title>
    <style type="text/css">
        body {
            background-image: url("images/timg2.jpg") ;
        }
    </style>
</head>
<body>
<a href="addLeave.jsp"></a>
<table width="600px" border="1px" align="center">
<tr>
    <th>请假人姓名</th>
    <th>请假开始时间</th>
    <th>请假结束时间</th>
    <th>请假原因</th>
    <th>审批状态</th>
    <th>是否同意</th>
    <th>修改</th>
</tr>
    <c:if test="${leaves != null}" >
        <c:forEach items="${leaves}" var="leaves">
            <tr><td>${leaves.userName}</td>
                <td>${leaves.beginTime}</td>
                <td>${leaves.endTime}</td>
                <td>${leaves.reasons}</td>
                <td>${leaves.conditioning}</td>
                <td>
                    <a href="LeaveServlet?method=ratify&id=${leaves.id}">同意</a>
                </td>
                <td>
                    <a href="LeaveServlet?method=findById&id=${leaves.id}">修改</a>
                    <a href="LeaveServlet?method=deleteLeave&id=${leaves.id}">删除</a>
                </td>
            </tr>

        </c:forEach>
    </c:if>
</table>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/12
  Time: 10:04
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
    <style>
        body {
            background-image: url("images/u=1606974046,3479207604&fm=11&gp=0.jpg");
        }
    </style>
</head>
<body>
    <table align="center" width="500px" border="1px" >
        <form action="LeaveServlet?method=updateLeave&id=${leave.id}" method="post">
            <tr>
                <td>请假人姓名</td>
                <td><input type="text" name="userName" value="${leave.userName}"/></td>
            </tr>
            <tr>
                <td>请假开始时间</td>
                <td><input type="text" name="beginTime" value="${leave.beginTime}"/></td>
            </tr>
            <tr>
                <td>请假结束时间</td>
                <td><input type="text" name="endTime" value="${leave.endTime}"/></td>
            </tr>
            <tr>
                <td>请假原因</td>
                <td><input type="text" name="reasons" value="${leave.reasons}"/></td>
            </tr>
            <tr>
                <td>请假状态</td>
                <td><input type="text" name="conditioning" value="${leave.conditioning}"/></td>
            </tr>
            <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="提交">
            </td>
            </tr>
        </form>
    </table>

</body>
</html>

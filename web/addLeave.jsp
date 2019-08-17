<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/12
  Time: 11:36
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
        body {
            background-image: url("images/u=2457305625,2231421459&fm=26&gp=0.jpg");
        }
    </style>

</head>
<body>
<form action="LeaveServlet?method=addLeave" method="post">
    <table align="center" width="500px" border="1px">

        <tr>
            <td>请假人姓名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="date" name="beginTime"/></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="date" name="endTime"/></td>
        </tr>
        <tr>
            <td>请假原因</td>
            <td><input type="text" name="reasons"/></td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"/></td>
            <td><input type="submit" name="提交"/></td>
        </tr>

    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/6
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-image: url("images/u=2457305625,2231421459&fm=26&gp=0.jpg");
        }
    </style>
</head>
<body>
<form action="SalaryServlet?method=addSalary" method="post">
    <h4 align="center">增加员工工资信息</h4>
    <table align="center">
        <tr>
            <td>员工ID</td>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td>基本薪资</td>
            <td><input type="text" name="basic"></td>
        </tr>
        <tr>
            <td>饭补</td>
            <td><input type="text" name="eat"></td>
        </tr>
        <tr>
            <td>住房补贴</td>
            <td><input type="text" name="house"></td>
        </tr>
        <tr>
            <td>全勤奖</td>
            <td><input type="text" name="duty"></td>
        </tr>
        <tr>
            <td>扣税</td>
            <td><input type="text" name="scot"></td>
        </tr>
        <tr>
            <td>罚款</td>
            <td><input type="text" name="punishment"></td>
        </tr>
        <tr>
            <td>其他补助</td>
            <td><input type="text" name="other"></td>
        </tr>
        <tr>
            <td>发放时间</td>
            <td><input type="date" name="granTime"></td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>

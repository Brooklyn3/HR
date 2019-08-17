<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/8
  Time: 9:13
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
<table align="center" width="500px" border="1px">
    <form action="SalaryServlet?method=updateSalary&id=${salary.id}" method="post">
        <tr>
            <td>员工ID</td>
            <td>
                <input type="text" name="userId" value="${salary.userId}">
            </td>
        </tr>
        <tr>
            <td>基本薪资</td>
            <td>
                <input type="text" name="basic" value="${salary.basic}">
            </td>
        </tr>
        <tr>
            <td>饭补</td>
            <td>
                <input type="text" name="eat" value="${salary.eat}">
            </td>
        </tr>
        <tr>
            <td>住房补贴</td>
            <td>
                <input type="text" name="house" value="${salary.house}">
            </td>
        </tr>
        <tr>
            <td>全勤奖</td>
            <td>
                <input type="text" name="duty" value="${salary.duty}">
            </td>
        </tr>
        <tr>
            <td>扣税</td>
            <td>
                <input type="text" name="scot" value="${salary.scot}">
            </td>
        </tr>
        <tr>
            <td>罚款</td>
            <td>
                <input type="text" name="punishment" value="${salary.punishment}">
            </td>
        </tr>
        <tr>
            <td>其他补助</td>
            <td>
                <input type="text" name="other" value="${salary.other}">
            </td>
        </tr>
        <tr>
            <td>发放时间</td>
            <td>
                <input type="date" name="granTime" value="${salary.granTime}">
            </td>
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

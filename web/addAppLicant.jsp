<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/10
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Applicant</title>
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
<form action="AppLicantServlet?method=addAppLicant" method="post">
    <table align="center">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="0"/>男
                <input type="radio" name="gender" value="1"/>女
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>岗位</td>
            <td><input type="text" name="job"></td>
        </tr>
        <tr>
            <td>专业</td>
            <td><input type="text" name="specialty"></td>
        </tr>
        <tr>
            <td>工作经验</td>
            <td><input type="text" name="experience"></td>
        </tr>
        <tr>
            <td>学历</td>
            <td><input type="text" name="studyEffort"></td>
        </tr>
        <tr>
            <td>毕业学校</td>
            <td><input type="text" name="school"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="tel"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>登记时间</td>
            <td><input type="date" name="createTime"></td>
        </tr>
        <tr>
            <td>详细经历</td>
            <td>
                <textarea name="content" rows="30" cols="30"></textarea>
            </td>
        </tr>
        <tr>
            <td>是否入职</td>
            <td>
                <input type="radio" name="isHiring" value="0"/>是
                <input type="radio" name="isHiring" value="1"/>否
            </td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>

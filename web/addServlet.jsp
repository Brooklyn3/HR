<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/5
  Time: 8:35
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
<table align="center" width="500px" border="1px">
    <form action="LoginServlet?method=addUser" method="post">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="userName"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="0"/>男
                <input type="radio" name="gender" value="1"/>女
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birthday"/>
            </td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>
                <input type="date" name="createTime"/>
            </td>
        </tr>
        <tr>
            <td>用户描述</td>
            <td>
                <textarea name="content"></textarea>
            </td>
        </tr>
        <tr>
            <td>角色</td>
            <td>
                <select name="roleId">
                <option value="学生">学生</option>
                <option value="教师">教师</option>
                <option value="管理员">管理员</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置"/>
            </td>
            <td>
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </form>
</table>

</body>
</html>

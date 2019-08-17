<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/11
  Time: 0:08
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
<form action="TrainServlet?method=addTrain" method="post">
    <table align="center">
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>培训目的</td>
            <td><input type="text" name="purpose"></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="date" name="beginTime"></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="date" name="endTime"></td>
        </tr>
        <tr>
            <td>培训材料</td>
            <td><input type="text" name="datum"></td>
        </tr>
        <tr>
            <td>讲师</td>
            <td><input type="text" name="teacher"></td>
        </tr>
        <tr>
            <td>培训人ID</td>
            <td><input type="text" name="studentId"></td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td><input type="date" name="createTime"></td>
        </tr>
        <tr>
            <td>是否完成</td>
            <td>
                <input type="radio" name="educate" value="0">是
                <input type="radio" name="educate" value="1">否
            </td>
        </tr>
        <tr>
            <td>培训效果</td>
            <td>
                <textarea name="effect" rows="20" cols="20" style="margin: 0px;width: 469px;height: 97px;"></textarea>
            </td>
        </tr>
        <tr>
            <td>培训总能感觉</td>
            <td>
                <textarea name="summarize" rows="20" cols="20" style="margin: 0px;width: 469px;height: 97px;"></textarea>
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

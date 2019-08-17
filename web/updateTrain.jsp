<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/11
  Time: 0:03
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
<table align="center" class="table table-bordered table-hover table-responsive">
    <form action="TrainServlet?method=updateTrain&id=${train.id}" method="post">
        <tr>
            <td>课程名称</td>
            <td>
                <input type="text" name="name" value="${train.name}">
            </td>
        </tr>
        <tr>
            <td>培训目的</td>
            <td>
                <input type="text" name="purpose" value="${train.purpose}">
            </td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td>
                <input type="date" name="beginTime" value="${train.beginTime}">
            </td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td>
                <input type="date" name="endTime" value="${train.endTime}">
            </td>
        </tr>
        <tr>
            <td>培训材料</td>
            <td>
                <input type="text" name="datum" value="${train.datum}">
            </td>
        </tr>
        <tr>
            <td>讲师</td>
            <td>
                <input type="text" name="teacher" value="${train.teacher}">
            </td>
        </tr>
        <tr>
            <td>培训人ID</td>
            <td>
                <input type="text" name="studentId" value="${train.studentId}">
            </td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>
                <input type="date" name="createTime" value="${train.createTime}">
            </td>
        </tr>
        <tr>
            <td>是否完成</td>
            <td>
                <c:choose>
                    <c:when test="${train.educate == false}" >
                        <input type="radio" name="educate" value="0" checked/>是
                        <input type="radio" name="educate" value="1" />否
                    </c:when>
                    <c:when test="${train.educate == true}" >
                        <input type="radio" name="educate" value="0" />是
                        <input type="radio" name="educate" value="1" checked />否
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>培训效果</td>
            <td>
                <textarea name="effect">${train.effect}</textarea>
            </td>
        </tr>
        <tr>
            <td>培训总能感觉</td>
            <td>
                <textarea name="summarize">${train.summarize}</textarea>
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

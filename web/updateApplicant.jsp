<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/11
  Time: 15:41
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

<table align="center">
    <form action="AppLicantServlet?method=updateAppLicant&id=${applicant.id}">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${applicant.name}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <c:choose>
                    <c:when test="${user.gender == false}">
                        <input type="radio" name="gender" value="0" checked/>男
                        <input type="radio" name="gender" value="1"/>女
                    </c:when>
                    <c:when test="${user.gender == true}">
                        <input type="radio" name="gender" value="0"/>男
                        <input type="radio" name="gender" value="1" checked/>女
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${applicant.age}"></td>
        </tr>
        <tr>
            <td>岗位</td>
            <td><input type="text" name="job" value="${applicant.job}"></td>
        </tr>
        <tr>
            <td>专业</td>
            <td><input type="text" name="specialty" value="${applicant.specialty}"></td>
        </tr>
        <tr>
            <td>工作经验</td>
            <td><input type="text" name="experience" value="${applicant.experience}"></td>
        </tr>
        <tr>
            <td>学历</td>
            <td><input type="text" name="studyEffort" value="${applicant.studyEffort}"></td>
        </tr>
        <tr>
            <td>毕业学校</td>
            <td><input type="text" name="school" value="${applicant.school}"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="tel" value="${applicant.tel}"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" value="${applicant.email}"></td>
        </tr>
        <tr>
            <td>详细经历</td>
            <td><textarea name="content">${applicant.content}</textarea></td>
        </tr>
        <tr>
            <td>是否入职</td>
            <td>
                <%--                <c:choose>--%>
                <%--                    <c:when test="${msg.isHiring == false}" >--%>
                <%--                        <input type="radio" name="isHiring" value="0" checked />是--%>
                <%--                        <input type="radio" name="isHiring" value="1" />否--%>
                <%--                    </c:when>--%>
                <%--                    <c:when test="${msg.isHiring == true}">--%>
                <%--                        <input type="radio" name="isHiring" value="0" />是--%>
                <%--                        <input type="radio" name="isHiring" value="1" checked>否--%>
                <%--                    </c:when>--%>
                <%--                </c:choose>--%>
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

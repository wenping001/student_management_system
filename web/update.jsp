<%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>update</title>
</head>
<body>

    <form action="/student-management" method="post">
<%--        <input type="hidden" value="update" name="method">--%>
        姓名：<input type="text" name="name" value="${student.name}">
        <br>
        性别：<input type="text" name="sex" value="${student.sex}" readonly>
        <br>
        民族：<input type="text" name="nation" value="${student.nation}" readonly>
        <br>
        学号：<input type="text" name="studentID" value="${student.studentId}" readonly>
        <br>
        学院：<input type="text" name="school" value="${student.school}">
        <br>
        专业：<input type="text" name="major" value="${student.major}">
        <br>
        <button type="submit" value="修改">修改</button>
    </form>
</body>
</html>

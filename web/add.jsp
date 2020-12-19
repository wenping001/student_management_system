<%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/17
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form action="/student-management" method="post">
        姓名：<input type="text" name="student_name">
        <br>
        性别：<input type="radio" name="sex" value="0">女
        <input type="radio" name="sex" value="1">男
        <br>
        民族：<input type="text" name="nation">
        <br>
        学号：<input type="text" name="studentID">
        <br>
        学院：<input type="text" name="school">
        <br>
        专业：<input type="text" name="major">
        <br>
        <button type="submit" value="修改"></button>
    </form>
</body>
</html>

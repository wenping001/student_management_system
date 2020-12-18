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
    <form action="/add">
        <input type="text" name="student_name">
        <br>
        <input type="radio" name="sex" value="0">女
        <input type="radio" name="sex" value="1">男
        <br>
        <input type="text" name="nation">
        <br>
        <input type="text" name="studentID">
        <br>
        <input type="text" name="school">
        <br>
        <input type="text" name="major">
        <br>
        <input type="submit" value="添加">
    </form>
</body>
</html>

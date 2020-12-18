<%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/17
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h1><%=request.getAttribute("state")%></h1>

    <form action="/login" method="post">
        <input type="text" name="username" autocomplete="false">
        <br>
        <input type="password" name="password">
        <br>
        <input type="submit" value="登录">
    </form>
    <br>
    <input type="button" name="register" value="注册" ;>
    <br>
    <input type="button" name="forget" value="忘记密码">
</body>
</html>

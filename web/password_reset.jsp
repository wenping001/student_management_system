<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/20
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>password reset</title>
</head>
<body>
<section class="mb-5 text-center">

    <p>Set a new password</p>

    <form action="/change_password" method="post">

        <div class="md-form md-outline">
            <input type="password" id="newPass" class="form-control" name = "new-password">
            <label data-error="wrong" data-success="right" for="newPass">New password</label>
        </div>

        <div class="md-form md-outline">
            <input type="password" id="newPassConfirm" class="form-control">
            <label data-error="wrong" data-success="right" for="newPassConfirm">Confirm password</label>
        </div>

        <%
            User user = (User) request.getAttribute("user");
            String email = user.getEmail();
        %>

        <input type="hidden" name="user-email" value=<%=email%>>

        <button type="submit" class="btn btn-primary mb-4">Change password</button>

    </form>

    <div class="d-flex justify-content-between align-items-center mb-2">

        <u><a href="login.html">Back to Log In</a></u>

        <u><a href="signup.html">Register</a></u>

    </div>

</section>
</body>
</html>

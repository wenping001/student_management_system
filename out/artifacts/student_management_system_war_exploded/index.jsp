<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/19
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>

    <style type="text/css">
        <%@include file="WEB-INF/template2/vendor/bootstrap/css/bootstrap.min.css"%>
        <%@include file="WEB-INF/template2/fonts/font-awesome-4.7.0/css/font-awesome.min.css"%>
        <%@include file="WEB-INF/template2/vendor/animate/animate.css"%>
        <%@include file="WEB-INF/template2/vendor/select2/select2.min.css"%>
        <%@include file="WEB-INF/template2/vendor/perfect-scrollbar/perfect-scrollbar.css"%>
        <%@include file="WEB-INF/template2/css/util.css"%>
        <%@include file="WEB-INF/template2/css/main.css"%>
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    request.setAttribute("username",user.getName());
    int i = 1;
%>
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
                <table>
                    <thead>
                    <tr class="table100-head">
                        <th class="column1" style="width: 10px">序号</th>
                        <th class="column2">姓名</th>
                        <th class="column3">性别</th>
                        <th class="column4">民族</th>
                        <th class="column5">学号</th>
                        <th class="column6">学院</th>
                        <th class="column6">专业</th>
                        <th class="column6" colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${students}" var="student" >
                            <tr>
                                <td class="id"><%=i++%></td>
                                <td class="name">${student.name}</td>
                                <td class="sex">${student.sex}</td>
                                <td class="nation">${student.nation}</td>
                                <td class="studentID">${student.studentId}</td>
                                <td class="school" style="width: 200px">${student.school}</td>
                                <td class="major" style="width: 200px">${student.major}</td>
                                <td>
                                    <a href="/student-management?method=update&id=${student.studentId}"><button class="btn-success">修改</button></a>
                                </td>

                                <td>
                                    <a href="/student-management?method=delete&id=${student.studentId}"><button class="btn-danger">删除</button></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>




<!--===============================================================================================-->
<script src="WEB-INF/template2/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="WEB-INF/template2/vendor/bootstrap/js/popper.js"></script>
<script src="WEB-INF/template2/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="WEB-INF/template2/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="WEB-INF/template2/js/main.js"></script>
</body>
</html>

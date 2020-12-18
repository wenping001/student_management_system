<%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>学生信息管理系统</title>
    <style type="text/css">
      <%@include file="WEB-INF/css/bootstrap/3.3.6/bootstrap.css"%>
      <%@include file="WEB-INF/css/bootstrap/3.3.6/bootstrap-theme.css"%>
      <%@include file="WEB-INF/css/style.css"%>
    </style>
    <script src="WEB-INF/js/bootstrap/3.3.6/bootstrap.js"></script>
  </head>
  <body>
      <h2>欢迎你${user}</h2>
      <h1>学生管理系统</h1>
      <table class="table-bordered">
        <thead>
          <th>序号</th>
          <th>姓名</th>
          <th>性别</th>
          <th>民族</th>
          <th>学号</th>
          <th>学院</th>
          <th>专业</th>
          <th>操作</th>
        </thead>
      <tbody>
        <c:forEach items="${students}" var="student" >
          <tr>
            <td class="id">${student.id}</td>
            <td class="name">${student.name}</td>
            <td class="sex">${student.sex}</td>
            <td class="nation">${student.nation}</td>
            <td class="studentID">${student.studentId}</td>
            <td class="school" style="width: 200px">${student.school}</td>
            <td class="major" style="width: 200px">${student.major}</td>
            <td><a href=""><button class="btn btn-success">修改</button></a></td>
            <td><a href=""><button class="btn btn-danger">删除</button></a></td>
          </tr>
        </c:forEach>
      </tbody>

      </table>
  </body>
</html>

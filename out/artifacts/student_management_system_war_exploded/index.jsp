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
  </head>
  <body>
      <h2>欢迎你${user}</h2>
      <h1>学生管理系统</h1>
      <table>
        <tr>
          <th>序号</th>
          <th>姓名</th>
          <th>性别</th>
          <th>民族</th>
          <th>学号</th>
          <th>学院</th>
          <th>专业</th>
        </tr>
      <c:forEach items="${students}" var="student" >
        <tr>
          <td>${student.id}</td>
          <td>${student.name}</td>
          <td>${student.sex}</td>
          <td>${student.nation}</td>
          <td>${student.studentId}</td>
          <td>${student.school}</td>
          <td>${student.major}</td>
        </tr>
      </c:forEach>
      </table>
  </body>
</html>

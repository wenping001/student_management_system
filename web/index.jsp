<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 文平
  Date: 2020/12/19
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <%
        User user = (User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        int i = 1;
    %>

    <h2>欢 迎 你${user.name}</h2>
    <h1>学 生 管 理 系 统</h1>
<%--    <div class="query-box">--%>
<%--        <form action=action="/student-management method="get">--%>
<%--            <input type="hidden" value="query" name="method">--%>
<%--            姓名：<input type="text" name="name">--%>
<%--            <br>--%>
<%--            性别：<select name="sex" id="sex">--%>
<%--                <option value="null">全部</option>--%>
<%--                <option value="男">男</option>--%>
<%--                <option value="女">女</option>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            民族：<select name="nation" id="nation">--%>
<%--                <option value="null">全部</option>--%>
<%--                <c:forEach items= "${nations}" var="nation">--%>
<%--                    <option value=${nation}>${nation}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            学号：<input type="text" name="studentID">--%>
<%--            <br>--%>
<%--            学院：<select name="school" id="school">--%>
<%--                <option value="null">全部</option>--%>
<%--                <c:forEach items= "${schools}" var="school">--%>
<%--                    <option value=${school}>${school}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            专业：<select name="major" id="major">--%>
<%--                <option value="null">全部</option>--%>
<%--                <c:forEach items="${majors}" var="major">--%>
<%--                    <option value=${major}>${major}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            <button type="submit">查询</button>--%>
<%--        </form>--%>

        <a href="add.jsp">添加学生</a>
    </div>

    <table>
        <thead>
        <tr class="table100-head">
            <th class="id">序号</th>
            <th class="name">姓名</th>
            <th class="sex">性别</th>
            <th class="nation">民族</th>
            <th class="studentID">学号</th>
            <th class="school">学院</th>
            <th class="major">专业</th>
            <th class="option" colspan="2">操作</th>
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
</body>
</html>

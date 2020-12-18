package Servlet;

import Bean.Student;
import Dao.StudentDao;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        UserDao userDao  = new UserDao();
        ArrayList<Student> studentList;
        String state = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userDao.getUser(username,password)!=null){
            studentList = studentDao.listStudent();
            request.setAttribute("user",username);
            request.setAttribute("students",studentList);
            request.getRequestDispatcher("index.jsp").forward(request
            ,response);
        }
        else{
            state = "wrong";
            request.setAttribute("state",state);
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}

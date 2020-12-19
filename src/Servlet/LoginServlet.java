package Servlet;

import entity.Student;
import entity.User;
import service.LoginService;
import service.StudentService;
import service.impl.LoginServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    /**
     * 业务逻辑
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = loginService.login(username, password);
        List<Student> studentList = studentService.studentList();
        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.setAttribute("students",studentList);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.html").forward(request,response);
    }
}

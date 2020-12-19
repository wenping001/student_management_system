package Servlet;

import entity.Student;
import Dao.impl.StudentDaoImpl;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/student-management")
public class StudentServlet extends HttpServlet {
    List<Student> students = new ArrayList<>();
    StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        if (method==null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                students = studentService.studentList();
                request.setAttribute("students",students);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "delete":
                String idStr = request.getParameter("id");
                studentService.delete(idStr);
                response.sendRedirect("/student-management");
                break;
            case "update":
                break;
        }
    }
}

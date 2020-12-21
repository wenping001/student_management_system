package Servlet;

import entity.Student;
import Dao.impl.StudentDaoImpl;
import entity.User;
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
        String name = request.getParameter("name");
        String school = request.getParameter("school");
        String major = request.getParameter("major");
        String studentID = request.getParameter("studentID");

        studentService.update(studentID,name,school,major);
        response.sendRedirect("/student-management");
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
            case "add":
                String name = request.getParameter("student_name");
                String sex = request.getParameter("sex");
                String nation = request.getParameter("nation");
                String studentID = request.getParameter("studentID");
                String school = request.getParameter("school");
                String major = request.getParameter("major");
                Student student = new Student(name,sex,nation,studentID,school,major);
                studentService.addStudent(student);
                response.sendRedirect("/student-management");
            case "query":

                break;
            case "update":
                String id = request.getParameter("id");
                Student student1 = studentService.getByStudentID(id);
                request.setAttribute("student",student1);
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
        }
    }
}

package Servlet;

import entity.User;
import service.LoginService;
import service.SendEmailService;
import service.impl.LoginServiceImpl;
import service.impl.SendEmailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResetPasswordServlet",urlPatterns = "/reset_password")
public class ResetPasswordServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();
    SendEmailService emailService = new SendEmailServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = loginService.isValidEmail(email);
        if (user!=null){
            emailService.sendEmail(email);
            response.sendRedirect("check-email.jsp");
        }
        else{
            response.sendRedirect("forgotPassword.html");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        User user = loginService.isValidEmail(email);
        request.setAttribute("user",user);
        request.getRequestDispatcher("password_reset.jsp").forward(request,response);
    }
}

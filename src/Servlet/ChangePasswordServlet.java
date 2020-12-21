package Servlet;

import entity.User;
import service.ChangePasswordService;
import service.LoginService;
import service.impl.ChangePasswordServiceImpl;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet",urlPatterns = "/change_password")
public class ChangePasswordServlet extends HttpServlet {
    ChangePasswordService changePasswordService = new ChangePasswordServiceImpl();
    LoginService loginService = new LoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("new-password");
        String user_email = request.getParameter("user-email");
        User user = loginService.isValidEmail(user_email);
        changePasswordService.changePassword(user,newPassword);
    }
}

package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.model.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_AdminLogin", value = "/AdminLogin")
public class Servlet_AdminLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        Admin admin = new Admin();
        System.out.println(username + "" + password);
        AdminService service = new AdminService();
        try {
            admin=service.loginAdmin(username,password);
            if (admin.getName() !=null) {
                HttpSession session = request.getSession();
                session.putValue("username",admin.getUsername());
                response.sendRedirect("/cabservice_war_exploded/ViewData?action=all");

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("loginadmin.jsp");
                rd.forward(request, response);

            }
        } catch (SQLException e) {
            message=e.getMessage();
        } catch (ClassNotFoundException e) {
            message=e.getMessage();
        }



    }
}

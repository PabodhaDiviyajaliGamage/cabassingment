package com.cabservice.Controller;

import com.cabservice.Manage.AdminManage;
import com.cabservice.Service.AdminService;
import com.cabservice.model.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SendData", value = "/SendData")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        Admin admin = new Admin();
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("pass"));
        admin.setName(request.getParameter("name"));
        admin.setEmail(request.getParameter("email"));

        System.out.println(admin.getUsername() + " " + admin.getPassword() + "" + admin.getName() + "" + admin.getEmail());
        AdminService service = new AdminService();

        try {
            boolean result = service.Registeradmin(admin);

            if (result) {
                message = "Registation successfully" + admin.getName();
            } else {
                message = "registation failed try again";
            }

        } catch (SQLException e) {
            message = e.getMessage();
        } catch (ClassNotFoundException e) {
            message = e.getMessage();
        }
            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("registeradmin.jsp");
            requestDispatcher.forward(request,response);

    }
}

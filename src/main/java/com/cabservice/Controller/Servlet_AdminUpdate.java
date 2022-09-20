package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.model.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_AdminUpdate", value = "/AdminUpdate")
public class Servlet_AdminUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String message ="";

        Admin admin = new Admin();
        AdminService service = new AdminService();
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("pass"));
        admin.setName(request.getParameter("name"));
        admin.setEmail(request.getParameter("email"));
        System.out.println(admin.getUsername()+" "+admin.getPassword()+" "+admin.getName()+" "+admin.getEmail());

        try {
            boolean result =service.updateAdmin(admin);
            if(result)
            {
                message="Successfully updated";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("adminUpdate.jsp");
        rd.forward(request,response);
    }
}

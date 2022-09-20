package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.model.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet_ViewData", value = "/ViewData")
public class Servlet_ViewData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("all"))
        {
            getAll(request,response);
        }else {
            getdata(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        AdminService service = new AdminService();


        try {
            List<Admin>adminList = service.adminList();
            if(adminList.isEmpty())
            {
                message="No any Records";
            }
            request.setAttribute("adminList",adminList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("adminDash.jsp");
        rd.forward(request,response);
    }

    private void getdata(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String username = request.getParameter("uname");

        System.out.println(username);
        Admin admin = new Admin();
        AdminService service = new AdminService();

        try {
            admin=service.searchAdmin(username);
            if(admin.getName()==null)
            {
                message="There's no any record:"+username;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        request.setAttribute("username",admin.getUsername());
        request.setAttribute("password",admin.getPassword());
        request.setAttribute("name",admin.getName());
        request.setAttribute("email",admin.getEmail());
        RequestDispatcher rd = request.getRequestDispatcher("adminUpdate.jsp");
        rd.forward(request,response);
    }
}

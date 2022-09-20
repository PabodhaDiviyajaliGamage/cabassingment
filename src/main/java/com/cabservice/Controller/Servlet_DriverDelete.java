package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.Service.DriverService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_DriverDelete", value = "/DriverDelete")
public class Servlet_DriverDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String uname=request.getParameter("deteusername");

        System.out.println(uname);

        DriverService service = new DriverService();

        try {
            boolean result = service.deleteDriver(uname);
            if(result)
            {
                message="delete records";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        HttpSession session =request.getSession();
        session.setAttribute("Deletemessage",message);
        response.sendRedirect("/cabservice_war_exploded/DriverView?action=all");
    }
}

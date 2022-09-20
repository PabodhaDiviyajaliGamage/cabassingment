package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.model.Driver;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_DriverLogin", value = "/DriverLogin")
public class Servlet_DriverLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String message="";

            String username = request.getParameter("uname");
            String password=request.getParameter("pass");
            Driver driver = new Driver();
            System.out.println(username +" "+ password);

            DriverService service = new DriverService();

        try {
            driver = service.loginDriver(username,password);
            if(driver.getName()!=null)
            {
                HttpSession session = request.getSession();
                session.putValue("username",driver.getUsername());
                session.putValue("Dname",driver.getName());
                session.putValue("dnumber",driver.getPhonenumber());
                response.sendRedirect("/cabservice_war_exploded/DriverView?action=all");

            }else {
                RequestDispatcher rd = request.getRequestDispatcher("loginDriver.jsp");
                rd.forward(request,response);
            }
        } catch (SQLException e) {
            message = e.getMessage();
        } catch (ClassNotFoundException e) {
            message=e.getMessage();
        }
    }
}

package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.Service.DriverService;
import com.cabservice.model.Admin;
import com.cabservice.model.Driver;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_DriverUpdate", value = "/DriverUpdate")
public class Servlet_DriverUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message ="";

        Driver driver = new Driver();
        DriverService service = new DriverService();
   driver.setUsername(request.getParameter("username"));
     driver.setPassword( request.getParameter("pass"));
   driver.setName(request.getParameter("name"));

       driver.setPhonenumber(Integer.parseInt(request.getParameter("phone")));
     driver.setLisence(request.getParameter("lsence"));
     driver.setAddress(request.getParameter("address"));


        System.out.println(driver.getUsername()+" "+driver.getPassword()+" "+driver.getName()+""+driver.getAddress()+""+driver.getLisence()+""+driver.getPhonenumber());

        try {
            boolean result =service.updateDriver(driver);
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
        RequestDispatcher rd = request.getRequestDispatcher("DriverUpdate.jsp");
        rd.forward(request,response);

    }
}

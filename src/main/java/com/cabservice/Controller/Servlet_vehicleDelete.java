package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.Service.VehicleService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_vehicleDelete", value = "/vehicleDelete")
public class Servlet_vehicleDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String message="";
        String username=request.getParameter("uname");
        System.out.println(username);

        VehicleService service = new VehicleService();

        try {
            boolean result = service.deleteAdmin(username);
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
        response.sendRedirect("/cabservice_war_exploded/vehicleDash?action=all ");
    }
}

package com.cabservice.Controller;

import com.cabservice.Service.AdminService;
import com.cabservice.Service.VehicleService;
import com.cabservice.model.Admin;
import com.cabservice.model.Vehicle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_vehileUpdate", value = "/vehileUpdate")
public class Servlet_vehileUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        Vehicle  vehicle = new Vehicle();
        VehicleService service = new VehicleService();
        vehicle.setNumber(request.getParameter("number"));
        vehicle.setModel(request.getParameter("model"));
        vehicle.setFueltype(request.getParameter("fuel"));
        vehicle.setLicense(request.getParameter("license"));
        System.out.println(vehicle.getNumber()+" "+vehicle.getFueltype()+" "+vehicle.getModel()+" "+vehicle.getLicense());

        try {
            boolean result =service.updatevehicle(vehicle);
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
        RequestDispatcher rd = request.getRequestDispatcher("vehicleUpdate.jsp");
        rd.forward(request,response);
    }
}

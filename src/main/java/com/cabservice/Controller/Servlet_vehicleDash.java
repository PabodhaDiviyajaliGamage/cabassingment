package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.Service.VehicleService;
import com.cabservice.model.Driver;
import com.cabservice.model.Vehicle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet_vehicleDash", value = "/vehicleDash")
public class Servlet_vehicleDash extends HttpServlet {
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

    private void getdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";

        String username = request.getParameter("deteusername");
        System.out.println(username);
        Vehicle vehicle = new Vehicle();
        VehicleService service = new VehicleService();

        try {
            vehicle=service.searchVehicle(username);
            if(vehicle.getModel()==null)
            {
                message="There's no any record:"+username;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        request.setAttribute("number",vehicle.getNumber());
        request.setAttribute("model",vehicle.getModel());
        request.setAttribute("fuel",vehicle.getFueltype());
        request.setAttribute("license",vehicle.getLicense());

        RequestDispatcher rd = request.getRequestDispatcher("vehicleUpdate.jsp");
        rd.forward(request,response);

    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";


        VehicleService service = new VehicleService();

        try {
            List<Vehicle> vehicleList = service.driverList();
            if(vehicleList.isEmpty())
            {
                message="No any Records";
            }
            request.setAttribute("vehicleList",vehicleList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("vehicleDash.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.Service.VehicleService;
import com.cabservice.model.Vehicle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet_VehicleRegistation", value = "/VehicleRegistation")
public class Servlet_VehicleRegistation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String message="";
        String number = request.getParameter("number");
        String model=request.getParameter("model");
        String fueltype=request.getParameter("fueltype");
        String license=request.getParameter("lisence");

        System.out.println(number+" "+model+" "+fueltype+" "+license);
        Vehicle vehicle = new Vehicle(number,model,fueltype,license);
        VehicleService service = new VehicleService();

        try {
            boolean result = service.registervehicle(vehicle);
            if(result)
            {
                message="Driver Registation successfull";
            }else {
                message="Driver Registation unsuccessfull";
            }
        }catch (Exception e)
        {
            message = e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher("vehihcleRegistation.jsp");
        rd.forward(request,response);
    }
}

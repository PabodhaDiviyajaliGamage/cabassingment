package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.model.Admin;
import com.cabservice.model.Driver;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet_DriverRegister", value = "/DriverRegister")
public class Servlet_DriverRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        Driver driver  =new Driver();
        driver.setUsername(request.getParameter("username"));
        driver.setPassword(request.getParameter("pass"));
        driver.setName(request.getParameter("name"));
        driver.setPhonenumber(Integer.parseInt(request.getParameter("pnumber")));
        driver.setAddress(request.getParameter("address"));
        driver.setLisence(request.getParameter("license"));


        System.out.println(driver.getUsername()+" "+ driver.getPassword()+" "+driver.getName()+" "
                +driver.getPhonenumber()+""+driver.getAddress()+" "+driver.getLisence());

        DriverService service = new DriverService();

        try {
            boolean result = service.registerDriver(driver);
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
        RequestDispatcher rd = request.getRequestDispatcher("registerdriver.jsp");
        rd.forward(request,response);
    }
}

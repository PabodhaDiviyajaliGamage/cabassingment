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
import java.util.List;

@WebServlet(name = "Servlet_DriverView", value = "/DriverView")
public class Servlet_DriverView extends HttpServlet {
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
        Driver driver = new Driver();
        DriverService service = new DriverService();

        try {
            driver=service.serchDriver(username);
            if(driver.getName()==null)
            {
                message="There's no any record:"+username;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        request.setAttribute("username",driver.getUsername());
        request.setAttribute("password",driver.getPassword());
        request.setAttribute("name",driver.getName());
        request.setAttribute("pnum",driver.getPhonenumber());
        request.setAttribute("lsence",driver.getLisence());
        request.setAttribute("address",driver.getAddress());
        RequestDispatcher rd = request.getRequestDispatcher("DriverUpdate.jsp");
        rd.forward(request,response);

    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        DriverService service = new DriverService();

        try {
            List<Driver> driverList = service.driverList();
            if(driverList.isEmpty())
            {
                message=" ";
            }
            request.setAttribute("driverList",driverList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("DriverDash.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.cabservice.Controller;

import com.cabservice.Service.DriverService;
import com.cabservice.Service.customerService;
import com.cabservice.model.Admin;
import com.cabservice.model.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_customer", value = "/customer")
public class Servlet_customer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        Customer customer = new Customer();
        customer.setUsername(request.getParameter("username"));
        customer.setPassword(request.getParameter("pass"));
        customer.setName(request.getParameter("name"));
        customer.setPnber(Integer.parseInt(request.getParameter("pnber")));
        customer.setAddress(request.getParameter("address"));

        System.out.println(customer.getUsername()+" "+customer.getPassword()+" "+customer.getName()+" "+customer.getPnber()+" "+customer.getAddress());


        customerService service = new customerService();

        try {
            boolean result = service.RegisterCustomer(customer);
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
        RequestDispatcher rd = request.getRequestDispatcher("registerCustomer.jsp");
        rd.forward(request,response);

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer customer = new Customer();
        System.out.println(username + "  " + password);
        customerService service = new customerService();

        try {
            customer=service.loginCustomer(username,password);
            if(customer.getName() !=null)
            {
                HttpSession session=request.getSession();
                session.putValue("username",customer.getUsername());
                response.sendRedirect("customerdash.jsp");
            }else {
                RequestDispatcher rd = request.getRequestDispatcher("customerLogin.jsp");
                rd.forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }




}

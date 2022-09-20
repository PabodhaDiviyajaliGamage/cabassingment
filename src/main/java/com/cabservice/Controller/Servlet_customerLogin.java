package com.cabservice.Controller;

import com.cabservice.Service.customerService;
import com.cabservice.model.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_customerLogin", value = "/Servlet_customerLogin")
public class Servlet_customerLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
     String uname=request.getParameter("username");
        String pass = request.getParameter("password");

            customerService service = new customerService();
        try {
            customer=service.loginCustomer(uname,pass);
           if(customer.getUsername().equals(uname))
           {
               HttpSession session = request.getSession();
               session.putValue("username",customer.getUsername());
               session.putValue("cnum",customer.getPnber());
               session.putValue("cname",customer.getName());

               response.sendRedirect("/cabservice_war_exploded/Bookingview?action=all");

           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(uname.equals("sakila") && pass.equals("1234"))
        {
            response.sendRedirect("customerdash.jsp");
        }
    }
}

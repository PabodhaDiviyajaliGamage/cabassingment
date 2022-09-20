package com.cabservice.Controller;

import com.cabservice.Service.Bookingservice;
import com.cabservice.model.Booking;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_bookingUpdate", value = "/bookingUpdate")
public class Servlet_bookingUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Booking booking = new Booking();
            String name=request.getParameter("Dname");
            String number=request.getParameter("Dnumber");
            int id = Integer.parseInt(request.getParameter("id"));

            booking.setId(id);
            booking.setDname(name);
            booking.setDnumber(number);

        System.out.println(booking.getId()+" "+booking.getDname()+" "+booking.getDnumber());
        Bookingservice bookingservice = new Bookingservice();

        try {
            boolean result  = bookingservice.update(booking);
            if(result)
            {
                System.out.println("Comform Successfull");
            }else{
                System.out.println("Try Again");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       response.sendRedirect("/cabservice_war_exploded/Servlet_BookingAll?action=all");


    }
}

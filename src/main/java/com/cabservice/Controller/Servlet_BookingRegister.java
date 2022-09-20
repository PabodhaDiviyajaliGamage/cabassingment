package com.cabservice.Controller;

import com.cabservice.Service.Bookingservice;
import com.cabservice.model.Booking;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_BookingRegister", value = "/bookingRegister")
public class Servlet_BookingRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Booking booking = new Booking();
        String message="";

        booking.setCusmobile(request.getParameter("cnmber"));
        booking.setCusname(request.getParameter("cname"));
        booking.setTo(request.getParameter("to"));
        booking.setFrom(request.getParameter("from"));

        System.out.println(booking.getCusname()+" "+booking.getCusmobile()+" "+booking.getTo()+" "+booking.getFrom());

        Bookingservice bookingservice = new Bookingservice();
        try {
            boolean result = bookingservice.RegisterBooking(booking);
            if(result)
            {
                System.out.println("booking successfully");
            }else{
                System.out.println("Try Again");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rd = request.getRequestDispatcher("register_Booking.jsp");
        rd.forward(request,response);

    }
}

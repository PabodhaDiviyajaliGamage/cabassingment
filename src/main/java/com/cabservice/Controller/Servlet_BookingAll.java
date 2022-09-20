package com.cabservice.Controller;

import com.cabservice.Service.Bookingservice;
import com.cabservice.model.Booking;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet_BookingAll", value = "/Servlet_BookingAll")
public class Servlet_BookingAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("all"))
        {
            getall(request,response);
        }
    }

    private void getall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bookingservice bookingservice = new Bookingservice();

        try {
            List<Booking>bookings =bookingservice.bookingsListDriver();
            if(bookings.isEmpty())
            {
                System.out.println("No any Records");
            }
            request.setAttribute("booking",bookings);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rd = request.getRequestDispatcher("Book_all.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

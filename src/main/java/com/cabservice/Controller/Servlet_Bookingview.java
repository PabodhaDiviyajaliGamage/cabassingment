package com.cabservice.Controller;

import com.cabservice.Service.Bookingservice;
import com.cabservice.model.Booking;
import com.mysql.cj.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_Bookingview", value = "/Bookingview")
public class Servlet_Bookingview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");;
        if(action.equals("all")){
            getAll(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

   private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Booking booking = new Booking();

       HttpSession session = request.getSession();
       String name = session.getValue("cname").toString();
        booking.setCusname(name);
        System.out.println(booking.getCusname());

        Bookingservice bookingservice = new Bookingservice();
        try {
            List<Booking>bookings = bookingservice.bookingsList(booking);
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
        RequestDispatcher rd = request.getRequestDispatcher("customerdash.jsp");
        rd.forward(request,response);

    }
}

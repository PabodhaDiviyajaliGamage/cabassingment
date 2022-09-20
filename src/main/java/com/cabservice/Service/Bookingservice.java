package com.cabservice.Service;

import com.cabservice.Manage.BookingManage;
import com.cabservice.model.Booking;

import java.sql.SQLException;
import java.util.List;

public class Bookingservice {

    public static boolean RegisterBooking(Booking booking) throws SQLException, ClassNotFoundException {
        return BookingManage.RegisterBook(booking);
    }

    public static boolean deleteBooking(String username) throws SQLException, ClassNotFoundException {
        return BookingManage.deleteBook(username);
    }

    public static List<Booking> bookingsList(Booking booking) throws SQLException, ClassNotFoundException {
        return BookingManage.bookingsList(booking);
    }
    public static List<Booking> bookingsListDriver() throws SQLException, ClassNotFoundException {
        return BookingManage.bookingsListDriver();
    }
    public static boolean update(Booking booking) throws SQLException, ClassNotFoundException {
        return BookingManage.update(booking);
    }
}

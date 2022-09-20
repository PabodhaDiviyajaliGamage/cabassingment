package com.cabservice.Manage;

import com.cabservice.model.Admin;
import com.cabservice.model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingManage {

    public static boolean RegisterBook(Booking booking) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query="insert into cabservice.booking(cusmobileNumber,customername,ToLocation,fromLocation,bookingstatus)values(?,?,?,?,'pending')";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, booking.getCusmobile());
        ps.setString(2, booking.getCusname());
        ps.setString(3, booking.getTo());
        ps.setString(4, booking.getFrom());

        boolean result =ps.executeUpdate()>0;
        return result;
    }
    public static boolean deleteBook(String username) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="delete from cabservice.booking where cusmobileNumber=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, username);
        boolean result =ps.executeUpdate()>0;
        return result;
    }

    public static List<Booking> bookingsList(Booking books) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query="SELECT * FROM cabservice.booking where customername=?";

        PreparedStatement ps= connection.prepareStatement(query);
        ps.setString(1,books.getCusname());
        ResultSet rs =ps.executeQuery();
        List<Booking>bookingsArray = new ArrayList<Booking>();
        while (rs.next())
        {
            Booking book= new Booking(rs.getInt("id"),rs.getString("cusmobileNumber"),rs.getString("customername"),rs.getString("ToLocation"),rs.getString("fromLocation"),rs.getString("Drivername"),rs.getString("Drivernumber"),rs.getString("bookingstatus") );
            bookingsArray.add(book);
        }
        return bookingsArray;
    }

    public static List<Booking> bookingsListDriver() throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query="SELECT * FROM cabservice.booking ";

        Statement ps= connection.createStatement();

        ResultSet rs =ps.executeQuery(query);
        List<Booking>bookingsArray = new ArrayList<Booking>();
        while (rs.next())
        {
            Booking book= new Booking(rs.getInt("id"),rs.getString("cusmobileNumber"),rs.getString("customername"),rs.getString("ToLocation"),rs.getString("fromLocation"),rs.getString("Drivername"),rs.getString("Drivernumber"),rs.getString("bookingstatus") );
            bookingsArray.add(book);
        }
        ps.close();
        connection.close();
        return bookingsArray;
    }

    public static boolean update(Booking booking) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query="update cabservice.booking set Drivername=?, Drivernumber=? ,bookingstatus='comform' where id=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, booking.getDname());
        ps.setString(2, booking.getDnumber());
        ps.setInt(3, booking.getId());


        boolean result =ps.executeUpdate()>0;
        ps.close();
        connection.close();
        return result;
    }

}

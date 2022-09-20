package com.cabservice.Manage;

import com.cabservice.model.Admin;
import com.cabservice.model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverManage {

    public static boolean registerDriver(Driver driver) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query = "insert into  cabservice.driver(username,password,name,phonenumber,address,License)values (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, driver.getUsername());
        ps.setString(2, driver.getPassword());
        ps.setString(3, driver.getName());
        ps.setInt(4, driver.getPhonenumber());
        ps.setString(5, driver.getAddress());
        ps.setString(6, driver.getLisence());

        boolean result = ps.executeUpdate() > 0;
        ps.close();
        connection.close();

        return result;
    }

    public static Driver loginDriver(String uname, String pass) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        Driver driver = new Driver();
        String query = "SELECT * FROM cabservice.driver where username=? and password=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, uname);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            driver.setUsername(rs.getString("username"));
            driver.setPassword(rs.getString("password"));
            driver.setName(rs.getString("name"));
            driver.setPhonenumber(rs.getInt("phonenumber"));
            driver.setAddress(rs.getString("address"));
            driver.setLisence(rs.getString("License"));


        }
        ps.close();
        connection.close();
        return driver;
    }

    public static List<Driver> driverList() throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.driver";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Driver> driverList = new ArrayList<Driver>();
        while (rs.next()) {
            Driver driver = new Driver(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("License"), rs.getInt("phonenumber"), rs.getString("address"));
            driverList.add(driver);
        }

        return driverList;
    }
    public static Driver serchDriver(String username ) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.driver where username =? ";
        PreparedStatement ps = connection.prepareStatement(query);
        Driver driver = new Driver();
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            driver.setUsername(rs.getString("username"));
            driver.setPassword(rs.getString("password"));
            driver.setName(rs.getString("name"));
            driver.setLisence(rs.getString("License"));
            driver.setPhonenumber(rs.getInt("phonenumber"));
            driver.setAddress(rs.getString("address"));
        }
        ps.close();
        connection.close();
        return driver;
    }

    public static boolean updateDriver(Driver driver) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="update cabservice.driver set username=?,password=?,name=?,phonenumber=?,address=?,License=?  where username=? ";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, driver.getUsername());
        ps.setString(2, driver.getPassword());
        ps.setString(3, driver.getName());
        ps.setInt(4, driver.getPhonenumber());
        ps.setString(5, driver.getAddress());
        ps.setString(6, driver.getLisence());
        ps.setString(7, driver.getUsername());
        boolean result = ps.executeUpdate() > 0;
        ps.close();
        connection.close();

        return result;
    }

    public static boolean deleteDriver(String username) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="delete from cabservice.driver where username=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, username);
        boolean result =ps.executeUpdate()>0;
        return result;
    }
}

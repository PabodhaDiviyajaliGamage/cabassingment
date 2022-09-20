package com.cabservice.Manage;

import com.cabservice.model.Admin;
import com.cabservice.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManage {
    public static boolean RegisterCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query="insert into cabservice.customer(username,password,name,phonenumber,address)values(?,?,?,?,?);";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getPassword());
        ps.setString(3, customer.getName());
        ps.setInt(4, customer.getPnber());
        ps.setString(5, customer.getAddress());


        boolean result =ps.executeUpdate()>0;
        return result;
    }

    public static Customer loginCustomer(String username,String password) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.customer where username=? and password=?";
        PreparedStatement ps = connection.prepareStatement(query);
        Customer customer= new Customer();
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setPnber(rs.getInt("phonenumber"));
            customer.setAddress(rs.getString("address"));

        }
        ps.close();
        connection.close();
        return customer;
    }
    public static List<Customer> CustomerListList() throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query="SELECT * FROM cabservice.customer;";
        Statement st  = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Customer>customerList = new ArrayList<Customer>();
        while (rs.next())
        {
        Customer customer = new Customer(rs.getString("username"), rs.getString("password"),rs.getString("name"),rs.getInt("phonenumber"), rs.getString("address") );

        }
        return customerList;
    }
    public static Customer searchAdmin(String username ) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.customer where username=?";
        PreparedStatement ps = connection.prepareStatement(query);
        Customer customer= new Customer();
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setPnber(rs.getInt("phonenumber"));
            customer.setAddress(rs.getString("address"));

        }
        ps.close();
        connection.close();
        return customer;
    }

    public static boolean UpdateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query="update cabservice.customer set username=? ,password=? , name=?, phonenumber=?, address=? where username=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getPassword());
        ps.setString(3, customer.getName());
        ps.setInt(4, customer.getPnber());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getUsername());


        boolean result =ps.executeUpdate()>0;
        return result;
    }
    public static boolean deleteCustomer(String username) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="delete from cabservice.customer where username=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, username);
        boolean result =ps.executeUpdate()>0;
        return result;
    }
}

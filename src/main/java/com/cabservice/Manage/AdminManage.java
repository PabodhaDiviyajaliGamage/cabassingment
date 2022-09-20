package com.cabservice.Manage;

import com.cabservice.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminManage {

    public static boolean RegisterAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query="insert into cabservice.admin(username,password,name,email)values(?,?,?,?)";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, admin.getUsername());
        ps.setString(2, admin.getPassword());
        ps.setString(3, admin.getName());
        ps.setString(4, admin.getEmail());

        boolean result =ps.executeUpdate()>0;
        return result;
    }

    public static Admin loginAdmin(String username,String password) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.admin where username=? and password=?;";
        PreparedStatement ps = connection.prepareStatement(query);
        Admin admin = new Admin();
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        admin.setUsername(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        admin.setName(rs.getString("name"));
        admin.setEmail(rs.getString("email"));
        }
        ps.close();
        connection.close();
        return admin;
    }


    public static List<Admin>adminList() throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query="SELECT * FROM cabservice.admin";
        Statement st  = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Admin>adminarray = new ArrayList<Admin>();
        while (rs.next())
        {
            Admin admin= new Admin(rs.getString("username"),rs.getString("password"),rs.getString("name"), rs.getString("email"));
            adminarray.add(admin);
        }
        return adminarray;
    }


    public static Admin searchAdmin(String username ) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "select * from cabservice.admin where username=? ";
        PreparedStatement ps = connection.prepareStatement(query);
        Admin admin = new Admin();
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setName(rs.getString("name"));
            admin.setEmail(rs.getString("email"));
        }
        ps.close();
        connection.close();
        return admin;
    }

    public static boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="update cabservice.admin set username=?,password=?,name=?,email=?where username=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, admin.getUsername());
        ps.setString(2, admin.getPassword());
        ps.setString(3, admin.getName());
        ps.setString(4, admin.getEmail());
        ps.setString(5, admin.getUsername());
        boolean result =ps.executeUpdate()>0;
        return result;
    }

   public static boolean deleteAdmin(String username) throws SQLException, ClassNotFoundException {
       Getconnection connector = new Database();
       Connection connection = connector.Getconnection();
       String query="delete from cabservice.admin where username=?";
       PreparedStatement ps  = connection.prepareStatement(query);

       //insert variables
       ps.setString(1, username);
       boolean result =ps.executeUpdate()>0;
       return result;
   }
}

package com.cabservice.Manage;

import com.cabservice.model.Admin;
import com.cabservice.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleMange {

    public static boolean Registervehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        Getconnection conncector = new Database();
        Connection connection = conncector.Getconnection();

        String query = "insert into cabservice.vehicle(number,model,fueltype,license)values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, vehicle.getNumber());
        ps.setString(2, vehicle.getModel());
        ps.setString(3, vehicle.getFueltype());
        ps.setString(4, vehicle.getLicense());

        boolean result = ps.executeUpdate() > 0;
        return result;
    }

    public static List<Vehicle> vehicleList( ) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();

        String query="SELECT * FROM cabservice.vehicle";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Vehicle>vehicleList = new ArrayList<Vehicle>();
        while (rs.next())
        {
            Vehicle vehicle= new Vehicle(rs.getString("number"),rs.getString("model"),rs.getString("fueltype"),rs.getString("license"));
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    public static Vehicle searchVehicle(String number ) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query = "SELECT * FROM cabservice.vehicle where number=? ";
        PreparedStatement ps = connection.prepareStatement(query);
        Vehicle vehicle = new Vehicle();
        ps.setString(1, number);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            vehicle.setNumber(rs.getString("number"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setFueltype(rs.getString("fueltype"));
            vehicle.setLicense(rs.getString("license"));
        }
        ps.close();
        connection.close();
        return vehicle;
    }

    public static boolean updatevehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="update cabservice.vehicle set number=?,model=?,fueltype=?,license=? where number=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, vehicle.getNumber());
        ps.setString(2, vehicle.getModel());
        ps.setString(3, vehicle.getFueltype());
        ps.setString(4, vehicle.getLicense());
        ps.setString(5, vehicle.getNumber());
        boolean result =ps.executeUpdate()>0;
        return result;
    }

    public static boolean deleteAdmin(String number) throws SQLException, ClassNotFoundException {
        Getconnection connector = new Database();
        Connection connection = connector.Getconnection();
        String query="delete from cabservice.vehicle where number=?";
        PreparedStatement ps  = connection.prepareStatement(query);

        //insert variables
        ps.setString(1, number);
        boolean result =ps.executeUpdate()>0;
        return result;
    }
}

package com.cabservice.Service;

import com.cabservice.Manage.DriverManage;
import com.cabservice.Manage.VehicleMange;
import com.cabservice.model.Driver;
import com.cabservice.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class VehicleService {

    public static boolean registervehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return VehicleMange.Registervehicle(vehicle);
    }

    public  static List<Vehicle> driverList () throws SQLException, ClassNotFoundException {
        return VehicleMange.vehicleList();
    }

    public static Vehicle searchVehicle(String number ) throws SQLException, ClassNotFoundException {
        return VehicleMange.searchVehicle(number);
    }

    public static boolean updatevehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return  VehicleMange.updatevehicle(vehicle);
    }
    public static boolean deleteAdmin(String number) throws SQLException, ClassNotFoundException {
        return  VehicleMange.deleteAdmin(number);
    }
}

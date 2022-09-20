package com.cabservice.Service;

import com.cabservice.Manage.AdminManage;
import com.cabservice.Manage.DriverManage;
import com.cabservice.model.Admin;
import com.cabservice.model.Driver;

import java.sql.SQLException;
import java.util.List;

public class DriverService {
    public static boolean registerDriver(Driver driver) throws SQLException, ClassNotFoundException {
        return DriverManage.registerDriver(driver);
    }

    public static Driver loginDriver(String uname,String pass) throws SQLException, ClassNotFoundException {
        return DriverManage.loginDriver(uname, pass);
    }


    public  static List<Driver>driverList () throws SQLException, ClassNotFoundException {
        return DriverManage.driverList();
    }

    public static Driver serchDriver(String username) throws SQLException, ClassNotFoundException {
        return  DriverManage.serchDriver(username);
    }
    public static boolean updateDriver(Driver driver) throws SQLException, ClassNotFoundException {
        return DriverManage.updateDriver(driver);
    }
    public static boolean deleteDriver(String  username) throws SQLException, ClassNotFoundException {
        return DriverManage.deleteDriver(username);
    }
}

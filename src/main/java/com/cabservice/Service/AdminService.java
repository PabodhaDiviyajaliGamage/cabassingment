package com.cabservice.Service;

import com.cabservice.Manage.AdminManage;
import com.cabservice.model.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminService {

    public  static boolean Registeradmin(Admin admin) throws SQLException, ClassNotFoundException {
        return AdminManage.RegisterAdmin(admin);
    }

    public static Admin loginAdmin(String username,String password) throws SQLException, ClassNotFoundException {
        return  AdminManage.loginAdmin(username,password);
    }

    public static List<Admin>adminList() throws SQLException, ClassNotFoundException {
        return AdminManage.adminList();
    }

    public static Admin searchAdmin(String username) throws SQLException, ClassNotFoundException {
        return  AdminManage.searchAdmin(username);
    }

    public static boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        return AdminManage.updateAdmin(admin);
    }

    public static boolean deleteAdmin(String  username) throws SQLException, ClassNotFoundException {
        return AdminManage.deleteAdmin(username);
    }
}

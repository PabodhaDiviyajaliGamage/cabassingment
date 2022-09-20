package com.cabservice.Service;

import com.cabservice.Manage.CustomerManage;
import com.cabservice.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class customerService {
    public static boolean RegisterCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return CustomerManage.RegisterCustomer(customer);
    }
    public static Customer loginCustomer(String username,String password) throws SQLException, ClassNotFoundException {
        return CustomerManage.loginCustomer(username,password);
    }

    public static List<Customer> CustomerListList() throws SQLException, ClassNotFoundException {
        return CustomerManage.CustomerListList();
    }
    public static Customer searchAdmin(String username ) throws SQLException, ClassNotFoundException {
        return CustomerManage.searchAdmin(username);
    }
    public static boolean UpdateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return CustomerManage.UpdateCustomer(customer);
    }

    public static boolean deleteCustomer(String username) throws SQLException, ClassNotFoundException {
        return CustomerManage.deleteCustomer(username);
    }
}

package com.cabservice.Manage;

import java.sql.Connection;
import java.sql.SQLException;

public interface Getconnection {
    public Connection Getconnection() throws SQLException, ClassNotFoundException;
}

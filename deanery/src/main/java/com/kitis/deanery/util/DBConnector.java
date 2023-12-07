package com.kitis.deanery.util;

import java.sql.*;

import javax.sql.rowset.RowSetProvider;

public class DBConnector {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection = null;
    private static String connStr = "jdbc:mysql://localhost:3306/deanery" + "?serverTimezone = UTC";

    public Connection dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC Driver has been registered!");

        try{
            connection = DriverManager.getConnection(connStr, "root", "12345");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            throw e;
        }

        return connection;
    }
}

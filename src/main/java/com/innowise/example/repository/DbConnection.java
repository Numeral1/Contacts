package com.innowise.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection connection = null;
    final String URL = "jdbc:mysql://localhost:3306/db_contacts?serverTimezone=Europe/Minsk&useSSL=false";
    final String username = "root";
    final String PASSWORD = "3344";
    private static DbConnection dbConnection;

    private DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, username, PASSWORD);
            System.out.println("connection is working");
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static DbConnection getInstance(){
        if(dbConnection == null){
            return new DbConnection();
        }
        return dbConnection;
    }


    public Connection getConnection() {

        return connection;
    }
}

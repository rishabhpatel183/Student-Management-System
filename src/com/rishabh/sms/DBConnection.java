package com.rishabh.sms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/Student_db";
            String username = "root";
            String password = "rishabh#/18";

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected Successfully!");

            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
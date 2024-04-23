package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/alimurung_javadb";
    //not yet declared
    private static final String USERNAME = "anais";
    private static final String PASSWORD = "092223_aa";

    //make static to be able to be used to the main
    public static Connection getConnection(){
        Connection c = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //identify the url, uname, and pwd
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connected");
        }catch (ClassNotFoundException | SQLException e){
//            throw new RuntimeException();
            e.printStackTrace();
        }

        return c;
    }


//    public static void main(String[] args) {
//        getConnection();
//    }
}

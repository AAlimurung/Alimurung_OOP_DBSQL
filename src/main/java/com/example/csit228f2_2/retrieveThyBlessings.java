package com.example.csit228f2_2;

import com.example.csit228f2_2.MySQLConnector;

import java.sql.*;

public class retrieveThyBlessings {
    public static void retrieveData(){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM users";
            ResultSet report = st.executeQuery(selectaQuery);

            //print tanan data through iteration
            while(report.next()){
                int id = report.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {}

    static int ifValid(String name, String pass){
        return 1;
    }
}

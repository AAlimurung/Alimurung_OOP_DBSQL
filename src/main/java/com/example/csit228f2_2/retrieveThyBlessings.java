package com.example.csit228f2_2;

import com.example.csit228f2_2.MySQLConnector;

import java.sql.*;

public class retrieveThyBlessings {
    public static void retrieveData(){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM statusers";
            ResultSet report = st.executeQuery(selectaQuery);

            //print tanan data through iteration
            while(report.next()){
                int id = report.getInt("id");
                String name=report.getString("name");
                String email=report.getString("email");
                System.out.println(id+" "+ name+" "+email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {}

    static int ifValid(String name, String pass){
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM statusers";
            ResultSet report = st.executeQuery(selectaQuery);

            //print tanan data through iteration
            while(report.next()){
                System.out.println(report.getString("username"));
                if(name.equals(report.getString("username"))){
                    System.out.println("Match Found!");
                }

                System.out.println(report.getString("password"));
                if(pass.equals(report.getString("password"))){
                    System.out.println("Match Found!");
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

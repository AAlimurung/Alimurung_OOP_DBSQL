package com.example.csit228f2_2;

import com.example.csit228f2_2.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTbl {
    public static void create(){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {

            //create thy query
            String createTblQuery = "CREATE TABLE IF NOT EXISTS statUsers (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(250) NOT NULL)";

            //execute query
            st.execute(createTblQuery);
            //extra message
            System.out.println("kono taaburu ga tsukura re ru");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {}
}

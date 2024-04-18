package com.example.csit228f2_2;

import com.example.csit228f2_2.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteYourStorage {
    public static void deleteData(String username, String password){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector .getConnection(); PreparedStatement st = c.prepareStatement(
                "DELETE FROM users WHERE username = ?"
        )) {
            int usernameToDelete = 2;

            //delete thy data
            st.setInt(1, usernameToDelete);

            //for updating data later
            int rowsDeleted = st.executeUpdate();

            //check if ang rows kay dili null
            if(rowsDeleted > 0){
                //extra message
                System.out.println("update inyong label");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {}
}

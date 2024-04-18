package com.example.csit228f2_2;

import java.sql.*;

//experiment: see if pwede ba mag-methods instead of a lot of classes
public class SQLMethods {
    //----------CREATION------------
    public static void create(){
        //try block can have this kind of condition para diretso ra auto-close
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

//---------INSERTION------------
    public static void insertData(String username, String password){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); PreparedStatement st = c.prepareStatement(
                "INSERT INTO statusers (username, password) VALUES (?, ?)"
        )) {
            //insert thy data
            st.setString(1, username);
            st.setString(2, password);

            //para ma-upload sa db
            int rowsInserted = st.executeUpdate();

            //check if ang rows kay dili null
            if(rowsInserted > 0){
                //extra message
                System.out.println("insertion g");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //check if "sign up" button is clicked twice
    //if: double-clicked: return 0, and do not store the second data to database; prompt user too
    //else: proceed as usual
    static int doubleChecker(String name, String pass){
        return 0;
    }

    //---------READ DATA------------
    public static void retrieveData(String name, String password){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM statusers";
            ResultSet report = st.executeQuery(selectaQuery);

            //print tanan data through iteration
            while(report.next()){
                int id = report.getInt("id");
                name = report.getString("username");
                password = report.getString("password");
                System.out.println(id+" "+ name+" "+ password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //checker if valid both username and password entered in log in
    //if valid: proceed as usual
    //else: return 0, clear fields, and prompt user
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

    //---------UPDATE------------
    //---------DELETE------------
}

package com.example.csit228f2_2;

import java.sql.*;

//experiment: see if pwede ba mag-methods instead of a lot of classes
public class SQLMethods {
    public static int pass_Num;

    //----------CREATION------------
    public static void create(){
        //try block can have this kind of condition para diretso ra auto-close
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {

            //create thy query
            String createTblQuery = "CREATE TABLE IF NOT EXISTS tblcharaUsers (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(250) NOT NULL)";

            String createTblArts = "CREATE TABLE IF NOT EXISTS tblartifacts(" +
                    "artID INT AUTO_INCREMENT PRIMARY KEY" +
                    "artifactSands VARCHAR(9999) NOT NULL" +
                    "artifactGoblet VARCHAR(9999) NOT NULL" +
                    "artifactCirclet VARCHAR(9999) NOT NULL" +
                    "artifactSet VARCHAR(99999) NOT NULL)";

            //execute query
            st.execute(createTblQuery);
            //extra message
            System.out.println("Finished furnishing: Table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//---------INSERTION------------
    //experiment: password hashing
    public static void insertData(String username, String password){
        try(Connection c = MySQLConnector.getConnection(); PreparedStatement st = c.prepareStatement(
                "INSERT INTO tblcharaUsers (username, password) VALUES (?, ?)"
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
    //if: double-clicked: return 1, and do not store the second data to database; prompt user too
    //else: proceed as usual
    static int doubleChecker(String name, String pass){
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM tblcharaUsers";
            ResultSet report = st.executeQuery(selectaQuery);
            while(report.next()){
                System.out.println(report.getString("username"));
                if(name.equals(report.getString("username"))){
                    System.out.println("Duplicate found!");
                }

                System.out.println(report.getString("password"));
                if(pass.equals(report.getString("password"))){
                    System.out.println("Duplicate found!");
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //check if textfields are null
    //if null: return 1, and do not store the second data to database; prompt user too
    //else: proceed as usual
    static int nullField(String name, String pass){
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM tblcharaUsers";
            ResultSet report = st.executeQuery(selectaQuery);

            while(report.next()){
                System.out.println(report.getString("username"));
                if(name.isBlank() && name.equals(report.getString("username"))){
                    System.out.println("Empty field");
                }

                System.out.println(report.getString("password"));
                if(pass.isBlank() && pass.equals(report.getString("password"))){
                    System.out.println("Empty field");
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //---------READ DATA------------
    public static void retrieveData(String name, String password){
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM qelusers";
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
            String selectaQuery = "SELECT * FROM qelusers";
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
    public static void updateData(String name, String pass) {
        //try block can have this kind of condition para auto-close
        try (Connection c = MySQLConnector.getConnection(); PreparedStatement st = c.prepareStatement(
                "UPDATE qelusers SET username = ?, password = ? WHERE id = ?"
        )) {
            int aideeUpdate = 2;
            //insert thy data
            st.setString(1, name);
            st.setString(2, pass);
            st.setInt(3, aideeUpdate);

            //for updating data later
            int rowsUpdated = st.executeUpdate();

            //check if ang rows kay dili null
            if (rowsUpdated > 0) {
                //extra message
                System.out.println("update inyong label");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUsername(String name) {
        //try block can have this kind of condition para auto-close
        try (Connection c = MySQLConnector.getConnection(); PreparedStatement st = c.prepareStatement(
                "UPDATE qelusers SET username = ? WHERE id = ?"
        )) {
            int aideeUpdate = 2;
            //insert thy data
            st.setString(1, name);
            st.setInt(3, aideeUpdate);

            //for updating data later
            int rowsUpdated = st.executeUpdate();

            //check if ang rows kay dili null
            if (rowsUpdated > 0) {
                //extra message
                System.out.println("Updated username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePassword(String pass) {
        //try block can have this kind of condition para auto-close
        try (Connection c = MySQLConnector.getConnection(); PreparedStatement st = c.prepareStatement(
                "UPDATE qelusers SET password = ? WHERE id = ?"
        )) {
            int aideeUpdate = 2;
            //insert thy data
            st.setString(2, pass);
            st.setInt(3, aideeUpdate);

            //for updating data later
            int rowsUpdated = st.executeUpdate();

            //check if ang rows kay dili null
            if (rowsUpdated > 0) {
                //extra message
                System.out.println("update inyong label");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---------DELETE------------
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
}

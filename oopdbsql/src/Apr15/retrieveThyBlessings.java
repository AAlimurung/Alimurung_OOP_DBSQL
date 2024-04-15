package Apr15;

import java.sql.*;

public class retrieveThyBlessings {
    public static void main(String[] args) {
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnection.getConnection(); Statement st = c.createStatement()) {
            String selectaQuery = "SELECT * FROM users";
            ResultSet report = st.executeQuery(selectaQuery);

            //print tanan data through iteration
            while(report.next()){
                int id = report.getInt("id");
                String name = report.getString("name");
                String email = report.getString("email");
                System.out.println("ID: " + id +
                        "\nName: " + name +
                        "\nEmail: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

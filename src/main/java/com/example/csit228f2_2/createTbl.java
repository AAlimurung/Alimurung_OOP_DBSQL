package Apr15;

import com.example.csit228f2_2.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTbl {
    public static void main(String[] args) {
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnector.getConnection(); Statement st = c.createStatement()) {

            //create thy query
            String createTblQuery = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL)";

            //execute query
            st.execute(createTblQuery);
            //extra message
            System.out.println("kono taaburu ga tsukura re ru");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

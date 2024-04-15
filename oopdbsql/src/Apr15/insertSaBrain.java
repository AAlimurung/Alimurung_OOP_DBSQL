package Apr15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertSaBrain {
    public static void main(String[] args) {
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnection.getConnection(); PreparedStatement st = c.prepareStatement(
                "INSERT INTO users (name, email) VALUES (?, ?)"
        )) {
            String name = "Ree Ash";
            String email = "ironoshizuku@gmail.com";

            //insert thy data
            st.setString(1, name);
            st.setString(2, email);

            //para ma-upload sa db
            int rowsInserted = st.executeUpdate();

            //check if ang rows kay dili null
            if(rowsInserted > 0){
                //extra message
                System.out.println("nang-insert nas linya");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package Apr15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateInyongLabel {
    public static void main(String[] args) {
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnection.getConnection(); PreparedStatement st = c.prepareStatement(
                "UPDATE users SET name = ?, email = ? WHERE id = ?"
        )) {
            String name = "Sha Ree";
            String email = "ironoshizuku@gmail.com";
            int aideeUpdate = 2;
            //insert thy data
            st.setString(1, name);
            st.setString(2, email);
            st.setInt(3, aideeUpdate);

            //for updating data later
            int rowsUpdated = st.executeUpdate();

            //check if ang rows kay dili null
            if(rowsUpdated > 0){
                //extra message
                System.out.println("i-update inyong label");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

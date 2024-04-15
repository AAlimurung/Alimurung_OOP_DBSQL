package Apr15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteYourStorage {
    public static void main(String[] args) {
        //try block can have this kind of condition para diretso ra siyag catch
        try(Connection c = MySQLConnection.getConnection(); PreparedStatement st = c.prepareStatement(
                "DELETE FROM users WHERE id = ?"
        )) {
            int aidee2Delete = 2;
            //delete thy data
            st.setInt(1, aidee2Delete);

            //for updating data later
            int rowsDeleted = st.executeUpdate();

            //check if ang rows kay dili null
            if(rowsDeleted > 0){
                //extra message
                System.out.println("freed up cache");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

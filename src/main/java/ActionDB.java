import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActionDB {

    // Database Tutorial
    public static void insert(String lastName, String firstName, String id) { // Insert into database
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO user (lastName, firstName, id) VALUES (?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, id);
            ps.execute();
            Message.msgDBInsert();
        } catch (SQLException e) {
            Message.msgError(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                Message.msgError(e);
            }
        }
    }
}

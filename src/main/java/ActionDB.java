import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ActionDB {

    // Database Tutorial <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // Insert into database <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    protected static void dbInsert(String lastName, String firstName, String id) {
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

    // Read from database <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    protected static void dbReadAllData() {
        String lastName, firstName, id;

        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tableName = "user";
        try {
            String sql = "SELECT * FROM " + tableName;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lastName = rs.getString("lastName");
                firstName = rs.getString("firstName");
                id = rs.getString("id");
                Message.msgDBPrUserRow(lastName, firstName, id);
            }
        } catch (SQLException e) {
            Message.msgError(e);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                Message.msgError(e);
            }
        }
    }

    protected static void dbReadSpecificRow(String selectEntity, String fromTable, String where, String whereEqualsTo) {
        String result;

        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // for some reason, prepareStatment has lots of problem, so screw it
            // ps = con.prepareStatement("SELECT * FROM user WHERE id = 1001");
            String sql = "SELECT " + selectEntity + " FROM " + fromTable + " WHERE " + where + " = " + whereEqualsTo;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            result = rs.getString(1);
            Message.msgDBPrUserRow(selectEntity, fromTable, where, whereEqualsTo, result);

        } catch (SQLException e) {
            Message.msgError(e);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                Message.msgError(e);
            }
        }
    }
}

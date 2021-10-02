import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;

public class DbConnection {
    public static Connection connect() {
        Connection con = null;
        String pathRoot = System.getProperty("user.dir");
        String pathRssFolder = "db";
        String pathFileName = "javaDatabaseTutorial.db";
        String filePath = pathRoot + File.separator + pathRssFolder + File.separator + pathFileName;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            Message.msgError(e);
        }
        return con;
    }
}

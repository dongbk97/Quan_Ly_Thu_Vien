package jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mySQL://localhost:3306/quan_ly_sach_jdbc", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//create class DBHelper for database connection
public class DBHelper {

    private DBHelper() {
    }

    public static Connection getConn() {
        Properties properties = new Properties();
        Connection conn = null;
        try {
            properties.load(new FileInputStream(new DBHelper().getClass().getResource("../Resource/db.properties").getPath()));
            Class.forName(properties.getProperty("jdbc.driver"));
            conn = DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.user"),
                    properties.getProperty("jdbc.password")
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn, PreparedStatement ps, ResultSet set) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

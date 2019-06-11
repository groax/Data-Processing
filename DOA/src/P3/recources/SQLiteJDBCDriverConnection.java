package P3.recources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection {
    /**
     * Connect to a sample database
     */

    protected Connection connect() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\Documents\\GitHub\\SQLite_DP\\Ovkaart.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

//            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
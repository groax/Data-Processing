package P1;

import java.sql.*;

public class Main extends OracleDB {
    public static void main(String[] args)  {
        Connection conn = getConnection();

        try {
            conn.prepareStatement("SELECT * from MEDEWERKERS").execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

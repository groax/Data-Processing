package P1;

//Vergeet deze import niet
import java.sql.*;

public class OracleDB {
	//Zorg ter voorbereiding dat je ojdbc.jar download en toevoegt aan je project.
	
	//Aanmaken van de variabelen die je connectie specificeren. In dit geval een gebruiker "harry" met password "harry"
	//Deze code gebruikt de tabel afdelingen van de casus uit het leerboek 
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
	private static final String DB_USER = "groax";
	private static final String DB_PASS = "Honden123!";
	private static Connection conn;

	public void OracleBaseDao() throws SQLException {
		try {
			Class.forName(DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		// Leg de connectie met de database
		this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public static Connection getConnection () {
		return conn;
	}
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}
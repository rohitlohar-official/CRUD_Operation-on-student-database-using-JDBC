package students_database_jdbc_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Util {

	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/student_db_jdbc";
	private static final String USERNAME = "rohit";
	private static final String PASSWORD = "Lohar@123";

	// =>Load & Register the Driver Classes
	public Database_Util() {
		try {
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Something went wrong");
		}
	}

	// =>Establish the Connection with Database server
	public Connection getConnecion() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}
}
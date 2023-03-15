package students_database_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import students_database_controller.Query;
import students_database_jdbc_util.Database_Util;

public class Students_DAO {

	Scanner sc = new Scanner(System.in);

	Database_Util database = new Database_Util();

	// =>insert Student Record
	public void insertStudentRecords() throws SQLException {
		try (Connection con = database.getConnecion();
				PreparedStatement preparedStatement = con.prepareStatement(Query.insertStudentsRecord())) {

			System.out.print("Enter Name :- ");
			String name = sc.nextLine();
			name = name.toUpperCase();
			preparedStatement.setString(1, name);

			System.out.print("Enter Address :- ");
			String address = sc.nextLine();
			address = address.toUpperCase();
			preparedStatement.setString(2, address);

			System.out.print("Enter Phone_No :- ");
			long phone_no = Long.parseLong(sc.nextLine());
			preparedStatement.setLong(3, phone_no);

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Record created sucessfully");
			} else {
				System.out.println("Insert record failed");
			}
		}
	}

	// =>get All Students_Record
	public void getAllStudentsRecords() throws SQLException {
		try (Connection con = database.getConnecion();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.getAllStudentsRecord());) {
			while (resultSet.next()) {
				System.out.println("Student id: " + resultSet.getInt(1));
				System.out.println("Student name: " + resultSet.getString(2));
				System.out.println("Student address: " + resultSet.getString(3));
				System.out.println("Student phone_no: " + resultSet.getLong(4));
				System.out.println("=========================================================================");
			}
		}
	}

	// =>get Students_Record By Id
	public void getStudentsRecordById(int id) throws SQLException {
		try (Connection connection = database.getConnecion();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.getStudentRecordById(id));) {
			if (resultSet.next()) {
				System.out.println("Student id: " + resultSet.getInt(1));
				System.out.println("Student name: " + resultSet.getString(2));
				System.out.println("Student address: " + resultSet.getString(3));
				System.out.println("Student phone_no: " + resultSet.getLong(4));
				System.out.println("=========================================================================");
			} else {
				System.out.println("Data is not available");
			}
		}
	}

	// =>update Record Of Entire one Row
	public void updateRecord_Of_Entire_one_Row(int id) throws SQLException {
		try (Connection connection = database.getConnecion();
				PreparedStatement preparedStatement = connection.prepareStatement(Query.updateStudentsRecord(id))) {

			System.out.print("Enter Name :- ");
			String name = sc.nextLine();
			name = name.toUpperCase();
			preparedStatement.setString(1, name);

			System.out.print("Enter Address :- ");
			String address = sc.nextLine();
			address = address.toUpperCase();
			preparedStatement.setString(2, address);

			System.out.print("Enter Phone_No :- ");
			long phone_no = Long.parseLong(sc.nextLine());
			preparedStatement.setLong(3, phone_no);
			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("Record update successfully");
			} else {
				System.out.println("Failed to update record.");
			}
		}
	}

	// =>delete Record Of Entire one Row
	public void deleteStudentRecordById(int id) throws SQLException {
		try (Connection connection = database.getConnecion(); Statement statement = connection.createStatement();) {
			int rows = statement.executeUpdate(Query.deleteStudentsRecordById(id));
			if (rows > 0) {
				System.out.println("Record deleted successfully");
			} else {
				System.out.println("Something went wrong");
			}
		}
	}
}
	

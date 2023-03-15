package students_database_controller;

public class Query {

	public static String insertStudentsRecord() {
		return "INSERT INTO students_info (name, address, phone_no) VALUES(?,?,?)";
	}

	public static String getAllStudentsRecord() {
		return "SELECT * FROM students_info";
	}

	public static String getStudentRecordById(int id) {
		return "SELECT * FROM students_info WHERE id = " + id;
	}

	public static String deleteStudentsRecordById(int id) {
		return "DELETE FROM students_info WHERE id = " + id;
	}

	public static String updateStudentsRecord(int id) {
		return "UPDATE students_info SET name = ? , address = ? , phone_no = ? WHERE id = " + id;
	}
}

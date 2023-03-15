package students_database_controller;

import java.sql.SQLException;
import java.util.Scanner;

import students_database_dao.Students_DAO;

public class Students_Main {

	public static void main(String[] args) throws SQLException {

		try (Scanner sc = new Scanner(System.in)) {
			Students_DAO student_dao = new Students_DAO();

			boolean loop = true;
			while (loop) {

				System.out.println("\n enter your choice");
				System.out.println("1. Insert the record");
				System.out.println("2. Displaying All the records");
				System.out.println("3. Displaying the records by id");
				System.out.println("4. Update All the records of 1 Row");
				System.out.println("5. Delete All the records of 1 Row");
				System.out.println("6. Exit");
				System.out.println("===========================================================");

				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Enter details of Student");
					student_dao.insertStudentRecords();
					break;
				case 2:
					System.out.println("Records of all student");
					student_dao.getAllStudentsRecords();
					break;
				case 3:
					System.out.println("Enter id to find all info of that id");
					int id = Integer.parseInt(sc.nextLine());
					student_dao.getStudentsRecordById(id);
					break;
				case 4:
					System.out.println("Enter id to update");
					int id1 = Integer.parseInt(sc.nextLine());
					student_dao.updateRecord_Of_Entire_one_Row(id1);
					break;
				case 5:
					System.out.println("Enter id to delete");
					int id2 = Integer.parseInt(sc.nextLine());
					student_dao.deleteStudentRecordById(id2);
					break;
				case 6:
					System.out.println("Thank you. Visit again.");
					loop = false;
					break;
				default:
					System.out.println("you have enter wrong option");
					break;
				}
			}
		}
	}
}


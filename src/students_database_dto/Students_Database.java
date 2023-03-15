package students_database_dto;

public class Students_Database {

	private int id;
	private String name;
	private String address;
	private long phone_no;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	@Override
	public String toString() {
		return "Student_Database [id=" + id + ", name=" + name + ", address=" + address + ", phone_no=" + phone_no
				+ "]";
	}

}
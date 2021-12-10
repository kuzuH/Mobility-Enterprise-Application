package tum.seba.mobilityservices.entity;

import java.util.Date;

public class Employee extends User {

	private String phoneNumber;
	private Date employmentDate;
	
	public Employee(String firstName, String lastName, String email, String password, String streetName,
			int houseNumber, String city, String phoneNumber, Date employmentDate) {
		super(firstName, lastName, email, password, streetName, houseNumber, city);
		this.phoneNumber = phoneNumber;
		this.employmentDate = employmentDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	@Override
	public String toString() {
		return "Employee [phoneNumber=" + phoneNumber + ", employmentDate=" + employmentDate + "]";
	}

}

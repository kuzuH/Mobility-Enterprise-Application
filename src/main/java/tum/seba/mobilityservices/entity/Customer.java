package tum.seba.mobilityservices.entity;

import java.util.Date;

public class Customer extends User {

	private String username;
	private Date dateOfBirth;
	
	public Customer(String firstName, String lastName, String email, String password, String streetName,
			int houseNumber, String city, String username, Date dateOfBirth) {
		super(firstName, lastName, email, password, streetName, houseNumber, city);
		this.username = username;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", dateOfBirth=" + dateOfBirth + "]";
	}

}

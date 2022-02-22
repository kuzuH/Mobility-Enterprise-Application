package tum.seba.mobilityservices.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ServicePoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	private String name;
	@NotBlank
	private String streetName;
	@Positive
	private int houseNumber;
	@NotBlank
	private String city;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Employee> employees;

	@OneToMany(mappedBy = "startLocation", cascade = CascadeType.PERSIST)
	private List<Rental> rentalsStart;

	@OneToMany(mappedBy = "endLocation", cascade = CascadeType.PERSIST)
	private List<Rental> rentalsEnd;

	@OneToMany(mappedBy = "currentLocation", cascade = CascadeType.PERSIST)
	private List<Vehicle> vehicles;

	public ServicePoint() {}

	public ServicePoint(String name, String streetName, int houseNumber, String city) {
		this.name = name;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.city = city;
	}

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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Rental> getRentalsStart() {
		return rentalsStart;
	}

	public void setRentalsStart(List<Rental> rentalsStart) {
		this.rentalsStart = rentalsStart;
	}

	public List<Rental> getRentalsEnd() {
		return rentalsEnd;
	}

	public void setRentalsEnd(List<Rental> rentalsEnd) {
		this.rentalsEnd = rentalsEnd;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "ServicePoint [id=" + id + ", name=" + name + ", streetName=" + streetName + ", houseNumber="
				+ houseNumber + ", city=" + city + "]";
	}

}

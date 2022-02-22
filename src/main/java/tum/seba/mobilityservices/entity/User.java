package tum.seba.mobilityservices.entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String streetName;
	@Positive
	private int houseNumber;
	@NotBlank
	private String city;

	public User() {}

	public User(String firstName, String lastName, String email, String password, String streetName, int houseNumber,
			String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
		this.password = passwordEncoder.encode(password);;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", streetName=" + streetName + ", houseNumber=" + houseNumber + ", city="
				+ city + "]";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("rolePlaceholder");
		return Collections.singletonList(simpleGrantedAuthority);
	}
	
	// the following user properties are currently not used, therefore all returning true
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}
	 
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
	    return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
	    return true;
	}

}

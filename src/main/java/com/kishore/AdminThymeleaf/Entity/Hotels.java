package com.kishore.AdminThymeleaf.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotels {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	//define no argument constructors
	public Hotels() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Hotels(String cityName, String hotelName, String email, String contactNumber) {
		super();
		this.cityName = cityName;
		this.hotelName = hotelName;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Hotels [id=" + id + ", cityName=" + cityName + ", hotelName=" + hotelName + ", email=" + email
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	
}

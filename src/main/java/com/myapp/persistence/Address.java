package com.myapp.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Address")
public class Address {
	
	 @Id
	    @GeneratedValue
	    private Long id;

private int houseNumber;
private String streetname;
private String location;
private String city;
private String state;
private  long zipcode;
private String username;
/*
@OneToOne(mappedBy = "address")
private UserEntity user;
*/
public Address()
{
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getHouseNumber() {
	return houseNumber;
}
public void setHouseNumber(int houseNumber) {
	this.houseNumber = houseNumber;
}
public String getStreetname() {
	return streetname;
}
public void setStreetname(String streetname) {
	this.streetname = streetname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public long getZipcode() {
	return zipcode;
}
public void setZipcode(long zipcode) {
	this.zipcode = zipcode;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}


/*public UserEntity getUser() {
	return user;
}
public void setUser(UserEntity user) {
	this.user = user;
}
*/
}

package com.myapp.persistence;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * UserEntity to save the user 
 * 
 
 */

@Entity
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))


public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    
	private String username;
    private String password;
    @Transient
    private String passwordConfirm;
    private String firstname;
    private String lastname;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_details")
    private Address address;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
    public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
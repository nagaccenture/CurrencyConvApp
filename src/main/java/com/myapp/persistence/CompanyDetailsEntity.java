package com.myapp.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CompanyDetails")

public class CompanyDetailsEntity {
	 @Id
	    @GeneratedValue
	    private Long id;

	    
		private String username;
	 
	    private String firstname;
	    private String lastname;
	    private String companyname;
	    private String designation;

	    
	    
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private Date startdate;



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



		public String getCompanyname() {
			return companyname;
		}



		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}



		public String getDesignation() {
			return designation;
		}



		public void setDesignation(String designation) {
			this.designation = designation;
		}



		public Date getStartdate() {
			return startdate;
		}



		public void setStartdate(Date startdate) {
			this.startdate = startdate;
		}
}

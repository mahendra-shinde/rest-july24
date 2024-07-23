package com.mahendra.demo1; // Class must be member of certain package

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer implements Serializable { // Classname must be in TitleCaseOnly and public 
	private String firstName;	// Properties must be private and in camelCase
	private String lastName;
	private String custId;
	private String email;
	
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
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer() {
	
	}
	public Customer(String firstName, String lastName, String custId, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.custId = custId;
		this.email = email;
	}
	
}

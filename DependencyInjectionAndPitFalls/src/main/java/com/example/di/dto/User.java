package com.example.di.dto;

import org.springframework.stereotype.Component;

@Component()
public class User {
	private String name;
	private String rollNumber;
	private String gender;

	
	
	public User() {
		super();
		System.out.println("User instantiated");
	}

	public User(String name, String rollNumber, String gender) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", rollNumber=" + rollNumber + ", gender=" + gender + "]";
	}
}

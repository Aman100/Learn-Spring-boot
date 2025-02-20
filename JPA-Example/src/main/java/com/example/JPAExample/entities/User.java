package com.example.JPAExample.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class User {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNumber;
	private String name;
	private String gender;
	private Short age;
	public User(String name, String gender, Short age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [rollNumber=" + rollNumber + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}

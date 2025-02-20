package com.example.JPAExample.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.JPAExample.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	/*
	 * Custom Query:
	 * findBySomething will be converted to JPQL
	 * findBy = Select * from User 
	 * findByGender = Select * from User where gender = "M"
	 * 
	 * For creating Complex Queries see "Spring Data supported Keywords"
	 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	 * 
	 * By Default Is has methods related to primary key columns. For support of Other columns / Complex queries 
	 * we need to use
	 * 1. Query Creation using Keywords (findBy) -> Translated to JPQL
	 * 2. JPQL
	 * 3. Native Query 
	 */
	public List<User> findByGender(String gndr);
	public List<User> findByRollNumberGreaterThan(Short age);
	
	/*
	 * Using JPQL, NativeQuery
	 * 1. JPQL
	 */
	
	@Query("select u from User u where u.name=:n")
	public List<User> getUserByName(@Param("n") String name);
	
	/*
	 * 2. Using Native Query
	 */
	
	@Query(value="select * from user where roll_number=?1",nativeQuery=true)
	public List<User> getUserByRollNumber(Integer rollNumber);
}

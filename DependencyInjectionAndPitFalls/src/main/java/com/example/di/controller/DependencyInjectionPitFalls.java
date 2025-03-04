/*
 * 1. Null Check Safety: Dependencies are guaranteed to be injected during execution of constructor
 * 2. Static: Cannot Autowire on static fields
 * 3. 
 */
package com.example.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.example.di.dto.Business;
import com.example.di.dto.User;

@Controller()
public class DependencyInjectionPitFalls {

	/*
	 * 1. Null Check Safety Example
	 */

	@Autowired()
	private User user;

	/*
	 * Bean Life Cycle in Short: Bean Creation -> Resolving Bean Dependency Here
	 * Bean is getting created, it's not created now, so User is not resolved yet using Field Injection.
	 * 
	 * To make it work, change field to Constructor Injection, so user dependency will
	 * get resolved during object creation
	 */

	/*
	 * public DependencyInjectionPitFalls()
	 * {
	 * System.out.println("DependencyInjectionPitFalls instantiated"); 
	 * if (user == null) System.out.println("object is null"); 
	 * else {
	 * user.setName("aman");
	 * user.setRollNumber("123");
	 * user.setGender("M");
	 * System.out.println(user);
	 * }
	 * }
	 */

	/*
	 * 2. Immutability Example Scenario: final variable is initialized in default
	 * constructor but
	 * 
	 * @Autowired also inject the dependency into the final variable which leads to
	 * reinitialization.
	 */

	/*
	 * Problem
	 * 
	 * @Autowired() private final Business business=null;
	 * 
	 * public void checkImmutability() 
	 * { 
	 * if (business == null) System.out.println("checkImmutability: object is null"); 
	 * else {
	 * business.setBusinessName("Hypertech Corporation");
	 * System.out.println("checkImmutability: " + business); 
	 * }
	 * }
	 */

	/*
	 * Solution: Using constructor injection won't break immutability
	 */

	private final Business business;

	@Autowired()
	public DependencyInjectionPitFalls(Business business) {
		System.out.println("DependencyInjectionPitFalls instantiated");
		this.business=business;
		this.business.setBusinessName("Hypertech Corporation");
		System.out.println(this.business);
	}
	
	/*
	 * 3. Cyclic Dependency: Can be broke with @Lazy()
	 */

}

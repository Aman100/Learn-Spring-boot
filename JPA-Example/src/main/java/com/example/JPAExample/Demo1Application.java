/*
 * This project contains following implementation of topics
 * 1. Setting up spring-data-jpa to connect with database
 * 2. Using CRUDRepository do to basic CRUD operations
 * 3. Writing Custom Queries (Which will be translated to JPQL)
 * 4. Using JPQL, NativeQuery Directly
 * 5. Spring Boot Dev Tools
 */

package com.example.JPAExample;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.JPAExample.entities.User;
import com.example.JPAExample.repository.UserRepository;

@SpringBootApplication
public class Demo1Application {
	
	/*
	 * Why I am unable to autowire userRepository:
	 * Autowiring is not supported in static fields
	 * @Autowired()
	 * private static UserRepository userRepository;
	 */
	
	private static UserRepository userRepository;
	private static User getDummyUser()
	{
		User user = new User("DUMMY","F",(short)45);
		return user;
	}
	
	public Demo1Application(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Demo1Application.class, args);
		if(userRepository==null) System.out.println("User Repository Is Null");
		else  System.out.println("User Repository Is NOT Null");
		/*
		 * UserRepository userRepository =
		 * applicationContext.getBean(UserRepository.class); User user1 = new
		 * User("Nishant","M",(short)31); User user2 = new
		 * User("Dheeraj","M",(short)32); User user3 = new User("Piyush","M",(short)34);
		 * List userList = List.of(user1,user2,user3);
		 */
		/*
		 * Save single User
		 * userRepository.save(user1);
		 */
		
		
		/*
		 * Save multiple User
		 * userRepository.saveAll(userList);
		 */
		
		
		/*
		 * Get / Update User findAll 
		 * - Iterable<User> findAllById 
		 * - Iterable<User>s
		 * 
		 * Optional<User> optUser = userRepository.findById(9); 
		 * User user = optUser.orElse(null); 
		 * if(user!=null ) 
		 * { 
		 * user.setName("Monalisha");
		 * user.setGender("F"); 
		 * user.setAge((short)27); 
		 * userRepository.save(user); 
		 * }
		 * else System.out.println("User doesn't exists");
		 */
		
		/*
		 * Delete User
		 * userRepository.deleteById(20);
		 */
		
		/*
		 * Custom Query
		 * 1. Find By Gender
		 */
		/*
		 * List<User> list1 = userRepository.findByGender("M");
		 * System.out.println("Find By Gender = M"); list1.stream().forEach(new
		 * Consumer<User>() { public void accept(User user) { System.out.println(user);
		 * } });
		 * 
		 * //2. Find By Age > age List<User> list2=
		 * userRepository.findByRollNumberGreaterThan((short)8);
		 * System.out.println("\nFind By RollNumber > 8"); list2.stream().forEach(new
		 * Consumer<User>(){ public void accept(User user) { System.out.println(user); }
		 * });
		 */
		
		/*
		 * Using JPQL
		 */
		/*
		 * List<User> list3 = userRepository.getUserByName("Amit");
		 * list3.stream().forEach(new Consumer<User>(){ public void accept(User user) {
		 * System.out.println(user); } });
		 */
		
		/*
		 * Using Native Query
		 */
		/*
		 * List<User> list4 = userRepository.getUserByRollNumber(19);
		 * list4.stream().forEach(new Consumer<User>(){ public void accept(User user) {
		 * System.out.println(user); } });
		 * 
		 * String arr[] =applicationContext.getBeanDefinitionNames(); for(String
		 * str:arr) { if(!(str.startsWith("org.springframework") ||
		 * str.startsWith("spring."))) System.out.println(str); }
		 */
	}

}


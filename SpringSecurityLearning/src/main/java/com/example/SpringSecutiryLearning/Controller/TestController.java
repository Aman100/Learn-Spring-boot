package com.example.SpringSecutiryLearning.Controller;

import com.example.SpringSecutiryLearning.pojo.Student;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

1. Adding spring security
2. Understand filter interception and change username,password and get sessionId
3. How filter works: Client -> FilterChain(Authentication & Authorization) -> Dispatcher Servlet -> Controller
4. How to handle case when someone stole SessionID and inject it into cookie and is doing request forgery
5. Implement Custom SecurityFilterChain


	Solution Point 4:
		1. User CSRF Token (Passed as hidden form field)
		2. Generate New SessionId upon every request
		3. SameSite=Strict in Cookie

	CSRF Token:
	Token to get rid of CSRF.

	Problem:
	1. Get request doesn't require CSRF token but request related to Update does
	2. People can steal JSESSIONID and inject into cookie and can do request forgery
	Solution:
	* Get CSRF token from HttpServletRequest and then pass CSRF token in header along with credentials and perform update
	* Ever request for csrf will generate new token

	Need to think:
	1. Getting CSRF token from hidden form field and passing it in header to update is not working
	2. Getting CSRF token from HttpServletRequest and passing it in header to update is working
 */

@RestController()
public class TestController {

	private List<Student> students = new ArrayList<>(Arrays.asList(
			new Student("Aman",91.5),
			new Student("Amit",92.5),
			new Student("Ankita",94.5)
	));
	@GetMapping(value="/getDetail")
	public String getDetail(HttpServletRequest httpServletRequest)
	{
		return "Hello Worldddd!!!" + ", SessionId: " + httpServletRequest.getSession().getId();
	}

	@GetMapping(value="/getCsrf")
	public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest)
	{
		return (CsrfToken) httpServletRequest.getAttribute("_csrf");
	}

	@GetMapping(value="/getStudents")
	public ResponseEntity<List<Student>> getStudents()
	{
		return ResponseEntity.ok(students);
	}

	@PostMapping(value="/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		students.add(student);
		return ResponseEntity.ok(student);
	}
}

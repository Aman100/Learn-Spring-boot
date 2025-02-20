package com.example.SpringSecutiryLearning.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean()
public SecurityFilterChain filterConfig(HttpSecurity httpSecurity) throws Exception {
    System.out.println("Invoked SecurityFilterChain config");

    //Disable CSRF
    httpSecurity.csrf(customer -> customer.disable());

    //Nobody can access resource without Authentication
    httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

    //Authentication Implementation method
    //1. Way Form Login (For Browser) --Session is Created when user is logged in through form and credentials are passed through form
    //httpSecurity.formLogin(Customizer.withDefaults());

    //2. Way Basic Authentication (For Postman) --Credentials are passed in Authorization header
    httpSecurity.httpBasic(Customizer.withDefaults());

    /*
    Stop CSRF
    1. Way One: Use CSRF Token (Even if someone steal sessionID then use CSRF(will be passed in Hidden form field and will be generated on every request))
    2. Generate New Session ID (Using way 2 Below)
     */

    /*
        1. By setting SessionCreationPolicy as STATELESS, Session will NOT be created AND no existing session will be used by SpringSecurity
        2. No point in using formLogin() as it required HttpSession to store SessionID
        3. Can only use httpBasic() as it can work without HttpSession
        4. Comment formLogin then try to access resource then, popup will occur which ask for username,password because of httpBasic()

            Available SessionCreationPolicy Options
            1. ALWAYS:
               A session is always created by Spring Security, even if it’s not needed.
               Useful for traditional web applications.
            2. IF_REQUIRED (Default):
               A session is created by Spring Security only if required (e.g., during login).
            3. NEVER:
               Spring Security will never create a session but will use an existing one if available.
            4. STATELESS:
               No session will be created or used by Spring Security. Each request must include authentication credentials.

               NOTE: Other tasks can create session

               On Every Request New SessionID will be created (No need to use CSRF Token)

     */

    httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return httpSecurity.build();
    //return httpSecurity.csrf(customizer -> customizer.disable()).build();
}

    /*
     Problem: Currently hardcoding username,password in application.properties which is bad, now what to do

     Solution: Need to write our own Authentication Mechanism instead of one provided using spring boot.

     UsernamePasswordAuthenticationFilter: This filter is responsible for username and password authentication.
     Internally it uses UserDetailsService for authentication.
     */

    @Bean()
    public UserDetailsService userDetailsService()
    {
        /*
            UserDetailsService is in interface.
            1. We can write custom implementation
            2. We can use existing implementation
         */

        //Using existing implementations and providing authentication details

        UserDetails userDetails1  = User.withUsername("aman123").password(passwordEncoder().encode("aman123")).roles("USER").build();
        return new InMemoryUserDetailsManager(userDetails1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for secure password storage
    }
}

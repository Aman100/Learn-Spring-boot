package com.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.di.controller.DependencyInjectionPitFalls;

@SpringBootApplication
public class DependencyInjectionAndPitFallsApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext coc = SpringApplication.run(DependencyInjectionAndPitFallsApplication.class,
				args);
		DependencyInjectionPitFalls dipf = coc.getBean(DependencyInjectionPitFalls.class);
		//dipf.checkImmutability();
	}
}

package com.example.demo;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		Object byName = context.getBean("time");
		LocalTime byType = context.getBean(LocalTime.class);
		Object byBoth = context.getBean("time", LocalTime.class);
		
		System.out.println(byName);
		System.out.println(byType);
		System.out.println(byBoth);
		
	}
	
	@Bean
	public LocalTime time() {
		LocalTime x = LocalTime.now();
		return x;
		
	}

}

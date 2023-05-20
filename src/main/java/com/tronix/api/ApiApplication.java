package com.tronix.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);
		System.out.println("welcome...");
//		context.getBean(HomeController.class);
	}

}

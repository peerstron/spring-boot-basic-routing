package com.tronix.api;

import com.tronix.api.model.Author;
import com.tronix.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);
		System.out.println("welcome...");
//		context.getBean(HomeController.class);
	}

	@Autowired
	private AuthorRepository authorRepository;

// Here we implemented the CommandLineRunner interface and got the run().
// This method start running as soon as our application start. It helps to seed my initial data into the db
	@Override
	public void run(String... args) throws Exception {

		Author author1 = new Author("Nyarko Ebenezer", "nyarko@tronixhub.com", "0543880082");
		authorRepository.save(author1);

		Author author2 = new Author("Ansah Eric", "anseric@gmail.com", "0509592510");
		authorRepository.save(author2);

	}
}

package com.example.SpringJDBC_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbc1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbc1Application.class, args);
		
		Alien a1 = context.getBean(Alien.class);
		
		a1.setId(101);
		a1.setName("Anshul");
		a1.setTech("Computer Science");
		
		// Save this a1 in database h2, create a object of Alien repo
		
		AlienRepo repo = context.getBean(AlienRepo.class);
		
		// save the object
		repo.save(a1);
		
		// get all object
		repo.findAll();
		
		
		
	}

}

package Anshul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApp3Application {

	public static void main(String[] args) {
		ApplicationContext conn = SpringApplication.run(WebApp3Application.class, args);

		Alien obj = conn.getBean(Alien.class);

		obj.code();
	}

}

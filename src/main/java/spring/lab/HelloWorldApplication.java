package spring.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println("End of main");
	}

	@Order(2)
	@Bean
	public CommandLineRunner run() {
		return args -> {
			System.out.println("Hello from Spring Boot main!");
		};
	}
}

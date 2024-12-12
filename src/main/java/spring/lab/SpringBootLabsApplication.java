package spring.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Bean;
import spring.lab.beantest.BeansTester;
import spring.lab.beantest.TestBean;

@SpringBootApplication
public class SpringBootLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabsApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	public TestBean testBean() {
		return new TestBean();
	}

	public BeansTester beansTester() {
		return new BeansTester(testBean(), testBean());
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> beansTester().compare();
	}
}

package com.charlie;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.charlie")
public class ExampleMain {

	public static void main(String[] args) {
		SpringApplication.run(ExampleMain.class);
	}

	@Bean
	public CommandLineRunner demo(TestRepository repository) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
		App exampleClient = context.getBean(App.class);
		exampleClient.run(repository);
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		emf.close();
		return null;
	}
}
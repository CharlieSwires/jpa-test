package com.charlie;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.charlie")
public class ExampleMain {
	static final Logger logger = LoggerFactory.getLogger(ExampleMain.class);
	static ConfigurableApplicationContext context = null;
	
	public static void main(String[] args) {
		context = SpringApplication.run(ExampleMain.class,args);
		//Controller exampleClient = context.getBean(Controller.class);
		//exampleClient.run();
		//EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		//emf.close();
	}


}
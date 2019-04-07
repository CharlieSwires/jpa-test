package com.charlie;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
		App exampleClient = context.getBean(App.class);
		exampleClient.run();
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		emf.close();
	}
}
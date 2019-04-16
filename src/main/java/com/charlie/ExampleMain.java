package com.charlie;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.charlie.repositories")
public class ExampleMain extends SpringBootServletInitializer{
//	static final Logger logger = LoggerFactory.getLogger(ExampleMain.class);
//	static ConfigurableApplicationContext context = null;
//	
//	public static void main(String[] args) {
//		context = SpringApplication.run(ExampleMain.class,args);
//		//Controller exampleClient = context.getBean(Controller.class);
//		//exampleClient.run();
//		//EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
//		//emf.close();
//	}


}
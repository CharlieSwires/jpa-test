package com.charlie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;



@Component
@ComponentScan(basePackages = {"com.charlie"})
@EnableJpaRepositories(basePackages = "com.charlie")
public class App {

	
	public void run(TestRepository repository) {
		demo(repository);
	}

	public void demo(TestRepository repository) {
		for(String [] item: repository.listAllInFull()) {
			System.out.println(item.toString());
		}
	}

}

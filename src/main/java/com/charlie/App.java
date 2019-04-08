package com.charlie;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;



@Service
@ComponentScan(basePackages = {"com.charlie"})
@EnableJpaRepositories(basePackages = "com.charlie")
public class App {


	@Autowired
	Test1Repository repository;

	public void run() {
		for(List<String> item: repository.listAllInFull()) {
			ExampleMain.logger.info(item.toString());
		}
	}


}

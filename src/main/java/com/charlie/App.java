package com.charlie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class App {

	@Autowired
	private TestRepository tRepository;
	
	  public void run() {
		
		App app = new App();
		app.demo(app.tRepository);
	}

	public void demo(TestRepository repository) {
		for(String [] item: repository.listAllInFull()) {
			System.out.println(item.toString());
		}
	}

}

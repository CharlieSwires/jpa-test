package com.charlie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/test")
public class Controller {
	
	@Autowired
	private MyService serv;
	//@PreAuthorize("hasRole('IT_DEVELOPER')")
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Results> get(){
		
		List<Result> rl = serv.run();
		Results results = new Results();
		results.setResults(rl);
		return new ResponseEntity<Results>(results, HttpStatus.OK);
		
	}


}

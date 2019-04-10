package com.charlie;

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
		Results rl = serv.run();	
		return new ResponseEntity<Results>(rl, HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllGender")
	public ResponseEntity<Iterable<Gender>> getAllGender(){
		Iterable<Gender> rl = serv.getAllGender();	
		return new ResponseEntity<Iterable<Gender>>(rl, HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllTest")
	public ResponseEntity<Iterable<Test>> getAllTest(){
		Iterable<Test> rl = serv.getAllTest();	
		return new ResponseEntity<Iterable<Test>>(rl, HttpStatus.OK);
	}


}

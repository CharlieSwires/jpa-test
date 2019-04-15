package com.charlie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/test")
public class Controller {
	
	@Autowired
	private MyService serv;
	//@PreAuthorize("hasRole('IT_DEVELOPER')")
	@RequestMapping(value = "/gelAll", method=RequestMethod.GET)
	public ResponseEntity<Results> get(){
		Results rl = serv.run();	
		return new ResponseEntity<Results>(rl, HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllGender", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Gender>> getAllGender(){
		Iterable<Gender> rl = serv.getAllGender();	
		return new ResponseEntity<Iterable<Gender>>(rl, HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllTest", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Test>> getAllTest(){
		Iterable<Test> rl = serv.getAllTest();	
		return new ResponseEntity<Iterable<Test>>(rl, HttpStatus.OK);
	}
	@RequestMapping(value = "/getOneTest/{i}", method=RequestMethod.GET)
	public ResponseEntity<Test> getOneTest(@PathVariable("i") Long id){
		return new ResponseEntity<Test>(serv.getOneTest(id),HttpStatus.OK);
	}	
	@RequestMapping(value = "/getOneGender/{i}", method=RequestMethod.GET)
	public ResponseEntity<Gender> getOneGender(@PathVariable("i") Long id){
		return new ResponseEntity<Gender>(serv.getOneGender(id),HttpStatus.OK);
	}

	@RequestMapping(value = "/postTest", method=RequestMethod.POST)
	public ResponseEntity<Test> postTest(@RequestBody Test test){
		test.setId(null);
		return new ResponseEntity<Test>(serv.save(test),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/postGender", method=RequestMethod.POST)
	public ResponseEntity<Gender> postGender(@RequestBody Gender test){
		test.setId(null);
		return new ResponseEntity<Gender>(serv.save(test),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/putTest", method=RequestMethod.PUT)
	public ResponseEntity<Test> putTest(@RequestBody Test test){
		return new ResponseEntity<Test>(serv.saveOrUpdate(test),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/putGender", method=RequestMethod.PUT)
	public ResponseEntity<Gender> putGender(@RequestBody Gender test){
		return new ResponseEntity<Gender>(serv.saveOrUpdate(test),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/deleteTest/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteTest(@PathVariable("id") Long id){
		return new ResponseEntity<Boolean>(serv.deleteTest(id),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/deleteGender/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteGender(@PathVariable("id") Long id){
		return new ResponseEntity<Boolean>(serv.deleteGender(id),HttpStatus.OK);
		
	}
}

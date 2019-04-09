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
		
		List<Result> rl = new ArrayList<Result>();
		for(String[] ls: serv.run()){
			Result r = new Result();
			r.setId(Integer.parseInt(ls[0]));
			r.setName(ls[1]);
			r.setGender(ls[2]);
			rl.add(r);
		}
		Results results = new Results();
		results.setResults(rl);
		return new ResponseEntity<Results>(results, HttpStatus.OK);
		
	}


}

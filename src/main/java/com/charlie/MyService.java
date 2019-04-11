package com.charlie;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@Service
@ComponentScan(basePackages = {"com.charlie"})
@EnableJpaRepositories(basePackages = "com.charlie")
public class MyService {


	@Autowired
	TestRepository repository;
	@Autowired
	GenderRepository genderRepository;

	public Results run() {
		List<Object[]> res = repository.listAllInFull();
		System.out.println("count = "+res.size());
		List<Result> results = new ArrayList<Result>();
		for(Object[] item: res) {
			Result r = new Result();
			r.setId(((BigInteger)item[0]).intValue());
			r.setName((String)item[1]);
			r.setGender((String)item[2]);
			results.add(r);
			System.out.println("result ="+r);
		}
		Results rs = new Results();
		rs.setResults(results);
		System.out.println("List<Result> = "+rs);
		return rs;
	}


	public Iterable<Test> getAllTest(){
		return repository.findAll();
	}
	public Iterable<Gender> getAllGender(){
		return genderRepository.findAll();
	}
	
	public Test getOneTest(Long id){
		Optional<Test> testOptional = repository.findById(id);
	
		if(testOptional.isPresent()){
			return testOptional.get();
		};
		return null;
	}	
	public Gender getOneGender(Long id){
		Optional<Gender> genderOptional = genderRepository.findById(id);
		
		if(genderOptional.isPresent()){
			return genderOptional.get();
		};
		return null;
	}


	public Test save(Test test) {
		return repository.save(test);
	}
}

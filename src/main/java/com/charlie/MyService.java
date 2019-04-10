package com.charlie;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@Service
@ComponentScan(basePackages = {"com.charlie"})
@EnableJpaRepositories(basePackages = "com.charlie")
public class MyService {


	@Autowired
	Test1Repository repository;

	public Results run() {
		List<Object[]> res = repository.listAllInFull();
		System.out.println("count = "+res.size());
		List<Result> results = new ArrayList<Result>();
		for(Object[] item: res) {
			Result r = new Result();
			r.setId((int)item[0]);
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


}

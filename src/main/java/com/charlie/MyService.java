package com.charlie;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@Service
@ComponentScan(basePackages = {"com.charlie"})
@EnableJpaRepositories(basePackages = "com.charlie")
public class MyService {

//	private SessionFactory sessionFactory;
//
//	public MyService() {
//		this.sessionFactory = new Configuration().configure().buildSessionFactory();
//	}

	@Autowired
	Test1Repository repository;

	public Results run() {
		List<Object[]> res = repository.listAllInFull();
//		List<Object[]> res = listAll();
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

//	public List<Object[]> listAll(){
//		Session session = this.sessionFactory.openSession();
//		Query q = session.createSQLQuery("SELECT DISTINCT( t.id), t.name, g.gender FROM TEST t, GENDER g JOIN GENDER ON (t.sex = g.id)");
//		List<Object[]> result = q.list();
//		return result;
//	}

}

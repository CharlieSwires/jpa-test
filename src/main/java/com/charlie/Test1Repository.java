package com.charlie;

import org.springframework.data.repository.CrudRepository;


public interface Test1Repository extends CrudRepository<Test, Long> {

	
    public Iterable<Test> findAll();

}

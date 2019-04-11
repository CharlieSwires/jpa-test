package com.charlie;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TestRepository extends CrudRepository<Test, Long> {


    @Query(value = "SELECT distinct( t.id), t.name, g.gender FROM Test t, Gender g join Gender ON (t.sex = g.id) order by t.id",
            nativeQuery=true
    )
    public List<Object[]> listAllInFull();
    
    public Iterable<Test> findAll();

}

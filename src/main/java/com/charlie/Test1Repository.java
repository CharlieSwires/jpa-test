package com.charlie;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface Test1Repository extends CrudRepository<Test, Long> {

    @Query(value = "SELECT distinct( t.id), t.name, g.gender FROM test t, gender g join gender ON (t.sex = g.id)",
            nativeQuery=true
    )
    public List<List<String>> listAllInFull();
}

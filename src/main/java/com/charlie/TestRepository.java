package com.charlie;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface TestRepository extends Repository<Test, Long> {

    @Query(value = "SELECT t.id, t.name, g.gender FROM test t, gender g JOIN gender ON (t.sex = g.id)",
            nativeQuery=true
    )
    public List<String[]> listAllInFull();
}

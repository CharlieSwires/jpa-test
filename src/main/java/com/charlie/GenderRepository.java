package com.charlie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface GenderRepository extends CrudRepository<Gender, Long> {

    public Iterable<Gender> findAll();
}

package com.charlie;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface GenderRepository extends CrudRepository<Gender, Long> {

    public Iterable<Gender> findAll();
    //public Optional<Gender> findById(ID id);
}
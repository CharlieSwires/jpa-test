package com.charlie.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.charlie.beans.Gender;


public interface GenderRepository extends CrudRepository<Gender, Long> {

    public Iterable<Gender> findAll();
}
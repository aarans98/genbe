package com.ananda.genbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ananda.genbe.model.entity.*;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
}

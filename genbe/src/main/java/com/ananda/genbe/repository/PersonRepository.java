package com.ananda.genbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ananda.genbe.model.entity.*;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	
	@Query(value = "SELECT nik FROM t_person d where d.nik = ?", nativeQuery = true)
	String findByNik(String nik);
	
	@Query(value = "SELECT nama FROM t_person d where d.nik = ?", nativeQuery = true)
	String findNameByNik(String nik);
	
	@Query(value = "SELECT alamat FROM t_person d where d.nik = ?", nativeQuery = true)
	String findAddressByNik(String nik);
	
}

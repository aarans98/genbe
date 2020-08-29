package com.ananda.genbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ananda.genbe.model.entity.Pendidikan;

public interface PendidikanRepository extends JpaRepository<Pendidikan, Integer> {
	
//	@Query(value = "SELECT nik, name, hp, tgl, tempatLahir, pendidikanTerakhir FROM ", nativeQuery = true)
	
}


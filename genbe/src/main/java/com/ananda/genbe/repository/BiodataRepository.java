package com.ananda.genbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ananda.genbe.model.entity.*;
import org.springframework.data.repository.query.Param;

public interface BiodataRepository extends JpaRepository<Biodata, Integer> {
	
//	@Query(value = "SELECT nik, name, hp, tgl, tempatLahir, pendidikanTerakhir FROM ", nativeQuery = true)
}

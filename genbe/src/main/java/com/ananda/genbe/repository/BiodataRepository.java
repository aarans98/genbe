package com.ananda.genbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ananda.genbe.model.entity.*;
import org.springframework.data.repository.query.Param;
import java.util.Date;

public interface BiodataRepository extends JpaRepository<Biodata, Integer> {
	
	@Query(value = "SELECT b.nohp FROM t_biodata b JOIN t_person p ON b.id_person = p.id_person WHERE p.nik = ?", nativeQuery = true)
	String findNoHpByPersonNik(String nik);
	
	@Query(value = "SELECT b.tanggal_lahir FROM t_biodata b JOIN t_person p ON b.id_person = p.id_person WHERE p.nik = ?", nativeQuery = true)
	Date findTglByPersonNik(String nik);
	
	@Query(value = "SELECT b.tempat_lahir FROM t_biodata b JOIN t_person p ON b.id_person = p.id_person WHERE p.nik = ?", nativeQuery = true)
	String findTempatLahirByPersonNik(String nik);

}

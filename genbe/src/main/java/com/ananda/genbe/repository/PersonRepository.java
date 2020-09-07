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
	
//	@Query(value = "SELECT d.nik, d.nama, d.alamat, "
//			+ "b.nohp, b.tanggal_lahir, b.tempat_lahir, "
//			+ "b.tanggal_lahir"
//			+ " FROM t_person d "
//			+ "JOIN t_biodata b ON d.id_person = b.id_person "
//			+ "JOIN t_pendidikna p ON b.id_person = p.id_personwhere "
//			+ "d.nik = ?", nativeQuery = true)
//	List<o> findPersonByNik(String nik);
}

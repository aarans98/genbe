package com.ananda.genbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ananda.genbe.model.entity.Pendidikan;

public interface PendidikanRepository extends JpaRepository<Pendidikan, Integer> {
	
	// Query
    @Query(value = "SELECT p.jenjang FROM t_pendidikan p JOIN t_person d ON p.id_person = d.id_person WHERE d.nik = ? ORDER BY p.tahunlulus asc LIMIT 1", nativeQuery = true)
    String findJenjangByNik(String nik);
 
}


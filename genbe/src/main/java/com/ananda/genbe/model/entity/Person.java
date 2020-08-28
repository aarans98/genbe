package com.ananda.genbe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", unique = true)
    private Integer kodePerson;
    
    @Column(name = "nik", unique = true, length = 16)
    private String nik;
    
    @Column(name = "nama", length = 50)
    private String nama;
    
    @Column(name = "alamat")
    private String alamat;
    
    
	public Integer getKodePerson() {
		return kodePerson;
	}

	public void setKodePerson(Integer kodePerson) {
		this.kodePerson = kodePerson;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
    
}

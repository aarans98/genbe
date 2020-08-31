package com.ananda.genbe.model.entity;

import java.sql.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_biodata")
public class Biodata {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bio", nullable = false, unique = true)
	private Integer kodeBio;
	
	@Column(name = "nohp", length = 16)
	private String noHp;
	
	@Column(name = "tanggal_lahir")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Column(name = "tempat_lahir", length = 50)
	private String tempatLahir;
	
	@OneToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person person;

	public Integer getKodeBio() {
		return kodeBio;
	}

	public void setKodeBio(Integer kodeBio) {
		this.kodeBio = kodeBio;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}

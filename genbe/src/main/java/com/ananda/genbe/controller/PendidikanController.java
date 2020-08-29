package com.ananda.genbe.controller;

import com.ananda.genbe.model.dto.*;
import com.ananda.genbe.model.entity.*;
import com.ananda.genbe.repository.*;
//import com.ananda.genbe.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
//import java.util.stream.Collectors;
//import java.time.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {

	@Autowired
	private PersonRepository personRepository;
	private PendidikanRepository pendidikanRepository;

	@Autowired
	public PendidikanController(PersonRepository personRepository, PendidikanRepository pendidikanRepository) {
		this.personRepository = personRepository;
		this.pendidikanRepository = pendidikanRepository;
	}
	
	public ValidasiDataDto validasiSukses() {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("true");
		dto.setMessage("data berhasil masuk");
		return dto;
	}
	
	public ValidasiDataDto validasiGagal() {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("false");
		dto.setMessage("data gagal masuk");
		return dto;
	}
	
	private Pendidikan convertToEntity(PendidikanDto pendDto) {
		Pendidikan pendidikan = new Pendidikan();
		pendidikan.setJenjang(pendDto.getJenjang());
		pendidikan.setInstitusi(pendDto.getInstitusi());
		pendidikan.setTahunMasuk(pendDto.getMasuk());
		pendidikan.setTahunLulus(pendDto.getLulus());
		return pendidikan;
	}
}

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
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	private BiodataRepository biodataRepository;

	@Autowired
	public PersonController(PersonRepository personRepository, BiodataRepository biodataRepository) {
		this.personRepository = personRepository;
		this.biodataRepository = biodataRepository;
	}

	public ValidasiDataDto validasiSukses() {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("true");
		dto.setMessage("data berhasil masuk");
		return dto;
	}

	public ValidasiDataDto validasiGagal1() {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("false");
		dto.setMessage("data gagal masuk jumlah digit nik tidak sama dengan 16");
		return dto;
	}

	public ValidasiDataDto validasiGagal2() {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("false");
		dto.setMessage("data gagal masuk, umur kurang dari 30");
		return dto;
	}

	// Soal No. 1
	@PostMapping
	public ValidasiDataDto insert(@RequestBody PersonDto dto) {
		Calendar calendar = Calendar.getInstance();
		Date birth = dto.getTgl();
		calendar.setTime(birth);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		LocalDate birth_day = LocalDate.of(year, month, date);
		LocalDate now = LocalDate.now();
		Period age = Period.between(birth_day, now);
		if (dto.getNik().length() != 16) {
			return validasiGagal1();
		} else if (age.getYears() < 30) {
			return validasiGagal2();
		} else {
			Person person = convertToEntityPerson(dto);
			personRepository.save(person);
			Biodata biodata = convertToEntity(dto);
			biodataRepository.save(biodata);
		}
		return validasiSukses();
	}

	// soal no. 2
//	@GetMapping("/{nik}")
//	public ValidasiDataDto get(@PathVariable String nik) {
//		
//	}

	private Person convertToEntityPerson(PersonDto dto) {
		Person person = new Person();
		person.setNik(dto.getNik());
		person.setNama(dto.getName());
		person.setAlamat(dto.getAddress());
		return person;
	}

	private Biodata convertToEntity(PersonDto dto) {
		Person person = new Person();
		person = personRepository.findById(dto.getKode()).get();
		Biodata biodata = new Biodata();
		biodata.setTempatLahir(dto.getTempatLahir());
		biodata.setDate(dto.getTgl());
		biodata.setNoHp(dto.getHp());
		biodata.setPerson(person);
		return biodata;
	}

}

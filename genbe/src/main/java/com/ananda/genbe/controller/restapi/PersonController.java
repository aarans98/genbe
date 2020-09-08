package com.ananda.genbe.controller.restapi;

import com.ananda.genbe.model.dto.*;
import com.ananda.genbe.model.entity.*;
import com.ananda.genbe.repository.*;
//import com.ananda.genbe.service.*;
import com.ananda.genbe.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	private BiodataRepository biodataRepository;
	private PendidikanRepository pendidikanRepository;

	@Autowired
	PersonService personService;

	@Autowired
	public PersonController(PersonRepository personRepository, BiodataRepository biodataRepository,
			PendidikanRepository pendidikanRepository) {
		this.personRepository = personRepository;
		this.biodataRepository = biodataRepository;
		this.pendidikanRepository = pendidikanRepository;
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

	public ValidasiDataDto validasiGagal3(String nik) {
		ValidasiDataDto dto = new ValidasiDataDto();
		dto.setStatus("false");
		dto.setMessage("data dengan nik " + nik + " tidak ditemukan");
		return dto;
	}
	
	// get all data
	@GetMapping("/get")
	public List<PersonDto> person() {
		List<Person> personList = personRepository.findAll();
		List<PersonDto> coba = new ArrayList<>();
		for (Person b:personList) {
			PersonDto personDto = new PersonDto();
			Biodata biodata = biodataRepository.findByPersonKodePerson(b.getKodePerson());
			personDto.setNik(b.getNik());
			personDto.setName(b.getNama());
			personDto.setAddress(b.getAlamat());
			personDto.setTgl(biodata.getDate());
			personDto.setTempatLahir(biodata.getTempatLahir());
			personDto.setHp(biodata.getNoHp());
			coba.add(personDto);
		}
		return coba;
	}

//	Soal No. 1
	@PostMapping("/insert")
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
			personService.insertPerson(person);
			dto.setKode(person.getKodePerson());
			Biodata biodata = convertToEntityBiodata(dto);
			personService.insertBiodata(biodata);
		}
		return validasiSukses();
	}
	
//	Soal no. 2
	@GetMapping("/{nik}")
	public ArrayList<Object> get(@PathVariable String nik) {
		ArrayList<Object> List = new ArrayList<Object>();
		ValidasiDataDto output = new ValidasiDataDto();

		if (personRepository.findByNik(nik) != null && nik.length() == 16) {
			Soal2Dto input = new Soal2Dto();
			OutputSoal2Dto outputTrue = new OutputSoal2Dto();
			Calendar calendar = Calendar.getInstance();
			Date birth = biodataRepository.findTglByPersonNik(nik);
			calendar.setTime(birth);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int date = calendar.get(Calendar.DATE);
			LocalDate birth_day = LocalDate.of(year, month, date);
			LocalDate now = LocalDate.now();
			Period age = Period.between(birth_day, now);
			input.setNik(personRepository.findByNik(nik));
			input.setName(personRepository.findNameByNik(nik));
			input.setAdress(personRepository.findAddressByNik(nik));
			input.setHp(biodataRepository.findNoHpByPersonNik(nik));
			input.setDate(biodataRepository.findTglByPersonNik(nik));
			input.setTempatLahir(biodataRepository.findTempatLahirByPersonNik(nik));
			input.setUmur(String.valueOf(age.getYears()));
			input.setPendidikan_terakhir(pendidikanRepository.findJenjangByNik(nik));
			outputTrue.setStatus("true");
			outputTrue.setMessage("succes");
			outputTrue.setData(input);
			List.add(outputTrue);
		} else if (nik.length() != 16) {
			output.setStatus("false");
			output.setMessage("data gagal masuk jumlah digit nik tidak sama dengan 16");
			List.add(output);
		} else {
			output.setStatus("false");
			output.setMessage("data dengan nik " + nik + " tidak ditemukan");
			List.add(output);
		}
		return List;
	}

	private Person convertToEntityPerson(PersonDto dto) {
		Person person = new Person();
		person.setNik(dto.getNik());
		person.setNama(dto.getName());
		person.setAlamat(dto.getAddress());
		return person;
	}

	private Biodata convertToEntityBiodata(PersonDto dto) {
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

package com.ananda.genbe.service;

import com.ananda.genbe.model.dto.*;
import com.ananda.genbe.repository.*;
import com.ananda.genbe.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PendidikanRepository pendidikanRepository;
	private BiodataRepository biodataRepository;
	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository, PendidikanRepository pendidikanRepository,
			BiodataRepository biodataRepository) {
		this.personRepository = personRepository;
		this.pendidikanRepository = pendidikanRepository;
		this.biodataRepository = biodataRepository;
	}
	
	@Override
	public void insertPendidikan(Pendidikan pend) {
		pendidikanRepository.save(pend);
	}
	
	@Override
	public void insertBiodata(Biodata bio) {
		biodataRepository.save(bio);
	}
	
	@Override
	public void insertPerson(Person person) {
		personRepository.save(person);
	}
	
	@Override
	public void insertPendidikan(@RequestBody List<PendidikanDto> pendDto, @PathVariable Integer idPerson) {
		for (int i = 0; i < pendDto.size(); i++) {
			Pendidikan pendidikan = convertToEntity(pendDto.get(i));
			if (pendidikan.getInstitusi() == null || pendidikan.getJenjang() == null ||
					pendidikan.getTahunLulus() == null || pendidikan.getTahunMasuk() == null) {
				Integer.parseInt("Saya");
			} else {
				pendidikan.setPerson(personRepository.findById(idPerson).get());
				pendidikanRepository.save(pendidikan);
			}
		}
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

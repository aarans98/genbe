package com.ananda.genbe.service;

import com.ananda.genbe.model.entity.*;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ananda.genbe.model.dto.*;

public interface PersonService {
	
//	public ValidasiDataDto getPerson(Biodata biodata);
//	List<Pendidikan> findByPersonIdPerson(Integer idPerson);
	public void insertBiodata(Biodata bio);
	public void insertPerson(Person person);
	public void insertPendidikan(Pendidikan pend);
	public Integer insertPendidikan(@RequestBody List<PendidikanDto> pendDto, @PathVariable Integer idPerson);
}

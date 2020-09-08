package com.ananda.genbe.controller.restapi;

import com.ananda.genbe.model.dto.*;
import com.ananda.genbe.model.entity.*;
import com.ananda.genbe.repository.*;
import com.ananda.genbe.service.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
	PersonService personService;
	
	@PostMapping("/{idPerson}")
	public ValidasiDataDto insertPendidikan(@RequestBody List<PendidikanDto> pendDto, @PathVariable Integer idPerson) {
		try {
			personService.insertPendidikan(pendDto, idPerson);
			return validasiSukses();
		}
		catch (Exception e) {
			return validasiGagal();
		}
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
	
}
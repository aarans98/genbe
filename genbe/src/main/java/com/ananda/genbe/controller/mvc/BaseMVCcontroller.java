package com.ananda.genbe.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseMVCcontroller {
	
	@GetMapping("base")
	public String base() {
		return "base";
	}
	
	// Menggunakan simple table
	@GetMapping("/soal1")
	public String soal1() {
		return "/biodata/soal1";
	}
	
	@GetMapping("/soal2")
	public String soal2() {
		return "/biodata/soal2";
	}
	
	@GetMapping("/soal3")
	public String soal3() {
		return "/biodata/soal3";
	}
	
	// Menggunakan data table
	@GetMapping("/index1")
	public String soalSatu() {
		return "/biodata/index1";
	}
	
	@GetMapping("/index2")
	public String soalDua() {
		return "/biodata/index2";
	}
	
	@GetMapping("/index3")
	public String soalTiga() {
		return "/biodata/index3";
	}
	
	@GetMapping("/htmlCoba2")
	public String coba() {
		return "/biodata/htmlCoba2";
	}
}
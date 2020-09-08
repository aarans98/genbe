package com.ananda.genbe.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseMVCController {
	
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
	@GetMapping("/1soal")
	public String soalSatu() {
		return "/biodata/1soal";
	}
	
	@GetMapping("/2soal")
	public String soalDua() {
		return "/biodata/2soal";
	}
	
	@GetMapping("/3soal")
	public String soalTiga() {
		return "/biodata/3soal";
	}
}
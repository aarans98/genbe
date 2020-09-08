package com.ananda.genbe.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BiodataController {
	
	@GetMapping("base")
	public String base() {
		return "base";
	}
	
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
}

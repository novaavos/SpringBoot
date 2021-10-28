package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aprendizagem")
public class aprendizagem {

	@GetMapping
	public String aprendizagem() {
		return "Essa é a hora de cair de cabeça no Spring!";
	}
	
}

package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidadeMentalidade")
public class habilidadeMentalidade {

	@GetMapping
	public String habMen() {
		return "Foi usado: Persistencia por a instalação do Spring dar errado umas 2 vezes <br>"
				+ "Mentalidade de crescimento por aprender um framework novo <br>"
				+ "Atenção aos detalhes para tentar não errar nenhuma linha de código!";
	}
	
}

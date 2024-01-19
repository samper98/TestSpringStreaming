package org.generation.italy.testspring.restcontroller;

import java.util.List;

import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Contenuto")
public class ContenutoRestController {
	
	@Autowired
	ContenutoRepository contenutoRepository;
	
	@GetMapping("/elenco")
	public List<Contenuto> elencoContenuti() {
		return contenutoRepository.findAll();
	}

	
}

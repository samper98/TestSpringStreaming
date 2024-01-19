package org.generation.italy.testspring.restcontroller;

import java.util.List;

import org.generation.italy.testspring.model.Regista;
import org.generation.italy.testspring.repository.RegistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regista")
public class RegistaRestController {
	
	@Autowired
	RegistaRepository registaRepository;
	
	@GetMapping("/elenco")
	public List<Regista> elencoRegisti() {
		return registaRepository.findAll();
	}

	
}

package org.generation.italy.testspring.restcontroller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.model.Regista;
import org.generation.italy.testspring.repository.RegistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("{id}")		//dettaglio di un contenuto
	public Regista dettaglioRegista(@PathVariable("id") int id) {
		Optional<Regista> result = registaRepository.findById(id);
		if (result.isPresent())
			return result.get();
		else
			return null;
	}
	

	
}

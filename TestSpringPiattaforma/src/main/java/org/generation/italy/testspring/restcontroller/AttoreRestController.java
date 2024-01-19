package org.generation.italy.testspring.restcontroller;

import java.util.List;

import org.generation.italy.testspring.model.Attore;
import org.generation.italy.testspring.repository.AttoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Attore")
public class AttoreRestController {
	
		
		@Autowired
		AttoreRepository attoreRepository;
		
		@GetMapping("/elenco")
		public List<Attore> elencoAttori() {
			return attoreRepository.findAll();
		}

		
	}

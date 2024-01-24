package org.generation.italy.testspring.controller;

import java.util.List;

import org.generation.italy.testspring.model.Attore;
import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.repository.AttoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/Attore")
public class AttoreController {
		@Autowired
		private AttoreRepository attoriRepository;
		@GetMapping("/elenco")
		@ResponseBody
		public String elencoAttori() {
			List<Attore> elencoAttori= attoriRepository.findAll();
			
			StringBuilder elenco=new StringBuilder();
			elenco.append("Numero attori: "+ elencoAttori.size());
			elenco.append("<br><br>"); // \n (andare a capo)
			for(Attore a:elencoAttori) {
				elenco.append(a.toString()+"<br>");
				elenco.append("---Contenuti:<br>");
				for (Contenuto c: a.getElencoContenuto())
					elenco.append("---"+c.toString()+"<br>");
			}
			return elenco.toString();
		}
}

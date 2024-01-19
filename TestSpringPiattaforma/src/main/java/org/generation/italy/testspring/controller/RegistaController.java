package org.generation.italy.testspring.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.model.Regista;
import org.generation.italy.testspring.repository.RegistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Regista")
public class RegistaController {
	
	@Autowired
	RegistaRepository registaRepository;
	
	
	@GetMapping("/elenco")			//gestisce una richiesta GET all'indirizzo /Fornitori/elenco
	@ResponseBody
	public String elencoRegisti() {
		List<Regista> elencoRegisti=registaRepository.findAll();
		StringBuilder elenco=new StringBuilder();
		elenco.append("Numero Registi: "+elencoRegisti.size());
		elenco.append("<br><br>");
		for (Regista r:elencoRegisti)
			elenco.append(r.toString()+ "<br>");
		return elenco.toString();

}
	
	@GetMapping("{id}")			//gestisce una richiesta GET all'indirizzo /Fornitori/elenco
	@ResponseBody
	public String dettaglioRegista(@PathVariable Integer id) {
		Optional<Regista> optRegista=registaRepository.findById(id);
		if (optRegista.isPresent())		//il prodotto è stato trovato
		{
			StringBuilder dettaglio=new StringBuilder();
			dettaglio.append(optRegista.get().toString()+"<br>");
			dettaglio.append("Registi forniti: <br>");
			for (Contenuto c: optRegista.get().getElencoContenuti())
				dettaglio.append(c.toString()+"<br>");
			return dettaglio.toString();
		}			
		else
			return "Regista non trovato!";
	}
}


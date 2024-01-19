package org.generation.italy.testspring.Controller;

import java.util.ArrayList;
import java.util.Collections;

import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Contenuto")

public class ContenutoController{
	
	@Autowired			
	ContenutoRepository contenutoRepository;
	
	@GetMapping
	@ResponseBody
	public String index() {
		return ("Benvenuto nella gestione della piattaforma");
	}
	
	@GetMapping("/elenco")
	@ResponseBody
	public String elencoContenuti(
			@RequestParam(required=false) String titolo,
			@RequestParam(required=false) String tipologia,
			@RequestParam(required=false) String genere,
			@RequestParam(required=false) Integer annoDiProduzionePartenza,
			@RequestParam(required=false) Integer annoDiProduzioneArrivo,
			@RequestParam(required=false) Integer durata,
			@RequestParam(required=false) String ordinamento) throws Exception {
		
		
		ArrayList<Contenuto> elencoContenuto = new ArrayList<>();
		if (titolo == null && tipologia == null && genere == null && annoDiProduzionePartenza == null)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findAll();
		else if (titolo != null && tipologia == null && genere == null && durata==0)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findByTitoloLike("%" + titolo + "%");
		 else if (genere != null && tipologia == null && titolo == null)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findByGenere(genere);
		else if (tipologia != null && genere == null && titolo == null)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findByTipologia(tipologia);
		else if (annoDiProduzionePartenza != null && genere == null && titolo == null)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository
					.findByAnnoDiProduzioneBetween(annoDiProduzionePartenza, annoDiProduzioneArrivo);
		else if (titolo!=null && genere !=null && tipologia==null && durata==0)
			elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findByTitoloLikeAndGenere("%" + titolo + "%", genere)	;	
			
		   if (ordinamento != null) {
			if (ordinamento.equals("asc"))
				Collections.sort(elencoContenuto);
			else if (ordinamento.equals("desc"))
				Collections.sort(elencoContenuto, Collections.reverseOrder());
			else
				throw new Exception("Ordinamento non valido");
		}
		   else if (durata != 0 && titolo == null && genere == null && tipologia == null)
				elencoContenuto = (ArrayList<Contenuto>) contenutoRepository.findByFasceDurata(durata);

		StringBuilder elenco = new StringBuilder();
		for (Contenuto c : elencoContenuto)
			elenco.append(c.toString() + "<br>");
		return elenco.toString();

}
}

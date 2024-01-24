package org.generation.italy.testspring.restcontroller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.testspring.model.Contenuto;
import org.generation.italy.testspring.repository.AttoreRepository;
import org.generation.italy.testspring.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contenuto")
public class ContenutoRestController {
	
	@Autowired
	ContenutoRepository contenutoRepository;
	@Autowired
	AttoreRepository attoriRepository;
	
	@GetMapping("/elenco")
	public List<Contenuto> elencoContenuti() {
		return contenutoRepository.findAll();
	}
	@GetMapping("{id}")		//dettaglio di un contenuto
	public Contenuto dettaglioContenuto(@PathVariable("id") int id) {
		Optional<Contenuto> result = contenutoRepository.findById(id);
		if (result.isPresent())
			return result.get();
		else
			return null;
	}
	// gestisce richieste POST /api/contenuto   (INSERIMENTO)
	@PostMapping  //invio dei dati (in questo caso in formato JSON) all'applicazione per l'inserimento
	public Contenuto inseerisciContenuto (@RequestBody Contenuto contenuto) { //il metodo riceve dal client un oggetto contenuto in formato JSON e lo inserisce nel database
		// attoriRepository.save(contenuto.getAttore());
		
		return contenutoRepository.save(contenuto);  //salva l'oggetto nel database
	}
	// gestisce richieste PUT /api/contenuto/<id>")  (AGGIORNAMENTO)
	@PutMapping  ("{id}")
	public Contenuto aggiornaContenuto (@PathVariable Integer id , @RequestBody Contenuto contenuto) {
		//1. recupero l'oggetto contenuto con quell'id
		Optional<Contenuto> result = contenutoRepository.findById(id);
		
		if (result.isPresent()) {
			Contenuto c = result.get();		//versione "attuale" del contenuto (quello che ho nel DB)

			//2. aggiorno (in memoria locale) l'oggetto recuperato
			c.setAnnoDiProduzione(contenuto.getAnnoDiProduzione());
			c.setDurata(contenuto.getDurata());
			c.setGenere(contenuto.getGenere());
			c.setTipologia(contenuto.getTipologia());
			c.setTitolo(contenuto.getTitolo());
			c.setRegista(contenuto.getRegista());
			//3. salvo le modifiche sul database (persist)
			return contenutoRepository.save(c);		//qui viene generata l'update
		}			
		else 
		return null;
	}
	// gestisce richieste DELETE /api/contenuto/<id>)  (ELIMINAZIONE)
		@DeleteMapping("{id}")		
		public void eliminaContenuto(@PathVariable Integer id)
		{		
			contenutoRepository.deleteById(id);
		}

}

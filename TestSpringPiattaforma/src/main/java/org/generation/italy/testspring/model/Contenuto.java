package org.generation.italy.testspring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Contenuto implements Comparable<Contenuto> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String titolo;

	@Column(nullable = false)
	private String tipologia;

	@Column(nullable = false)
	private String genere;

	@Column(nullable = false)
	private Integer annoDiProduzione;

	@Column(nullable = false)
	private Integer durata;

	@ManyToOne(optional = false)
	private Regista regista;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "elencoContenuti")
	private List<Attore> elencoAttori;
    
	public Contenuto() {
		super();
	}

	public Contenuto(String titolo, String tipologia, String genere, Integer annoDiProduzione, Integer durata) {
		super();
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.genere = genere;
		this.annoDiProduzione = annoDiProduzione;
	}

	public int getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public String getGenere() {
		return genere;
	}

	public Integer getAnnoDiProduzione() {
		return annoDiProduzione;
	}

	public Integer getDurata() {
		return durata;
	}

	public String getRegista() {
		return regista.getNome() + " " + regista.getCognome();
	}
	

	@Override
	public String toString() {
		return "Contenuto [id=" + id + ", titolo=" + titolo + ", tipologia=" + tipologia + ", genere=" + genere
				+ ", annoDiProduzione=" + annoDiProduzione + ", durata=" + durata + ", regista=" + regista.getNome()
				+ " " + regista.getCognome() + "]";
	}

	@Override
	public int compareTo(Contenuto o) { // compareTo per stringhe
		return this.titolo.compareTo(o.getTitolo());
	}

	public List<Attore> getElencoAttori() {
		return elencoAttori;
	}

	public void setElencoAttori(List<Attore> elencoAttori) {
		this.elencoAttori = elencoAttori;
	}

}

package org.generation.italy.testspring.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Attore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private String nome;

	private String cognome;

	private String nazionalita;

	private LocalDate dataNascita;

	@ManyToMany
	private List<Contenuto> elencoContenuti;

	public Attore() { // per spring
		super();
	}

	public Attore(String nome, String cognome, String nazionalita, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Attore [Id=" + Id + ", nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita
				+ ", dataNascita=" + dataNascita + "]";
	}

	public Integer getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public List<Contenuto> getElencoContenuto() {
		return elencoContenuti;
	}

}
package it.epicode.es1;

import java.time.LocalDate;

public class Info {
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	public Info(String nome, String cognome, LocalDate dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	@Override
	public String toString() {
		return String.format("Info [nome=%s, cognome=%s, dataDiNascita=%s]", nome, cognome, dataDiNascita);
	}
	
}

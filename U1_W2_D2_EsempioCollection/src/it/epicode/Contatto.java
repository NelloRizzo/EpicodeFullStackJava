package it.epicode;

import java.util.Objects;

public class Contatto {
	private String nome;
	private String cognome;
	private String nickname;
	private String telefono;

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNickname() {
		return nickname;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Contatto(String nome, String cognome, String nickname, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.nickname = nickname;
		this.telefono = telefono;
	}

	/*
	 * Poichè il recupero avviene attraverso il nickname, non potranno esistere due
	 * contatti con lo stesso nickname. Questo significa che il nickname dovrà
	 * essere la discriminante per decidere se due istanze della classe Contatto
	 * sono uguali. Quando abbiamo la necessità di distinguere due istanze di questa
	 * classe sulla base del valore dei campi, è NECESSARIO implementare il metodo
	 * equals() e il metodo hashCode().
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		// il metodo equals restituisce true quando this è da considerarsi uguale a obj
		
		// lo possiamo definire attraverso una definizione basata sul risultato del metodo
		// hashCode (per risparmiare tempo). Quindi osservare la implementazione di hashCode.
		
		// this == obj <=> obj è di classe contatto E l'hashCode di obj è uguale all'hashcode di this
		return obj instanceof Contatto && obj.hashCode() == this.hashCode();
	}
	
	@Override
	public int hashCode() {
		// Il metodo hashCode restituisce un intero che rappresenta una "chiave" per la classe.
		// Non esiste alcuna indicazione su come produrre tale intero, ma le linee guida
		// dicono che "se due oggetti sono uguali, allora avranno lo stesso hashCode".
		
		// Nella libreria di sistema esiste un modo per calcolare l'hashCode a partire da uno
		// o più valori:
		return Objects.hash(nickname);
	}

	@Override
	public String toString() {
		return String.format("Contatto [nome=%s, cognome=%s, nickname=%s, telefono=%s]", nome, cognome, nickname,
				telefono);
	}
}

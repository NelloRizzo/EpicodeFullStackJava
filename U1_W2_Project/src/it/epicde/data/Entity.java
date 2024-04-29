package it.epicde.data;

import java.util.Date;

import it.epicde.exceptions.DataMismatchLibraryException;
import it.epicde.exceptions.InvalidFieldsCountLibraryException;
import it.epicde.exceptions.LibraryException;

/**
 * Classe di base per tutte le entità gestite.
 *
 */
public class Entity {
	private Long id;
	private Date createdAt;

	public Entity() {
	}

	public Entity(Long id, Date createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	/**
	 * @return la chiave dell'entità.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @return la data di inserimento nel database.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return String.format("Entity(id=%s, createdAt=%s)", id, createdAt);
	}

	/**
	 * Salva in formato CSV i dati gestiti da questa classe.
	 * 
	 * @return le informazioni dell'istanza in formato CSV.
	 */
	public String toCsv() {
		return String.format("%s;%d;%d", getClass().getCanonicalName(), id, createdAt.getTime());
	}

	/**
	 * Recupera i dati della classe da un CSV.
	 * 
	 * @param csv la stringa dalla quale leggere.
	 * @return l'indice della prossima porzione di stringa da processare.
	 */
	public int fromCsv(String csv) {
		var parts = csv.split(";");
		// controlla che sta leggendo un dato della giusta classe!
		if (!getClass().getCanonicalName().equals(parts[0]))
			throw new DataMismatchLibraryException(getClass().getCanonicalName(), parts[0]);
		if (parts.length < 3)
			throw new InvalidFieldsCountLibraryException(3, parts.length);
		try {
			id = Long.parseLong(parts[1]);
			createdAt = new Date(Long.parseLong(parts[2]));
		} catch (NumberFormatException e) {
			throw new LibraryException(e);
		}
		// questa classe ha 3 informazioni gestite
		return 3;
	};

}

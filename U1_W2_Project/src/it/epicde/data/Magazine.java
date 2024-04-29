package it.epicde.data;

import java.util.Date;

import it.epicde.exceptions.InvalidFieldsCountLibraryException;
import it.epicde.exceptions.LibraryException;

/**
 * 
 * Una rivista.
 *
 */
public class Magazine extends Item {
	private Frequency frequency;

	public Magazine() {
	}

	public Magazine(Long id, Date createdAt, String isbn, String title, int pubYear, int pages, Frequency frequency) {
		super(id, createdAt, isbn, title, pubYear, pages);
		this.frequency = frequency;
	}

	/**
	 * 
	 * @return la periodicità.
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return String.format("Newspaper(%s, frequency=%s)", super.toString(), frequency);
	}

	@Override
	public String toCsv() {
		return String.format("%s;%d", super.toCsv(), frequency.ordinal());
	}

	@Override
	public int fromCsv(String csv) {
		int i = super.fromCsv(csv);
		var parts = csv.split(";");
		if (parts.length < (1 + i))
			throw new InvalidFieldsCountLibraryException(3, parts.length);
		try {
			frequency = Frequency.values()[Integer.parseInt(parts[i])];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new LibraryException("Invalid frequency value", e);
		} catch (NumberFormatException e) {
			throw new LibraryException(e);
		}
		// questa classe gestisce solo 1 attributo oltre a quelli della classe
		// precedente.
		return i + 1;
	}

}

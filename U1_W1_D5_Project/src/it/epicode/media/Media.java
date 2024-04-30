package it.epicode.media;

/**
 * Classe base per tutti gli elementi gestiti dal player multimediale.
 * 
 * @author Nello Rizzo
 *
 */
public abstract class Media {

	/**
	 * Memorizza il titolo dell'elemento.
	 */
	private String title;

	/**
	 * Costruttore.
	 * 
	 * @param title il titolo dell'elemento multimediale.
	 */
	public Media(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return il titolo dell'elemento multimediale.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Imposta il titolo dell'elemento multimediale.
	 * 
	 * @param title il valore del titolo.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s", getClass().getSimpleName(), title);
	}
}

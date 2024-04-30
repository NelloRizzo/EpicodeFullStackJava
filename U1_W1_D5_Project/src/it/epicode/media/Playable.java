package it.epicode.media;

/**
 * Definizione di un elemento riproducibile.
 * 
 * @author Nello Rizzo
 *
 */
public interface Playable {
	/**
	 * 
	 * @return la durata dell'elemento multimediale.
	 */
	int getDuration();

	/**
	 * Riproduce l'elemento multimediale.
	 */
	void play();
}

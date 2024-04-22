package it.epicode.media;

/**
 * Classe base per la gestione di immagini.
 * 
 * @author Nello Rizzo
 *
 */
public abstract class ImageMedia extends Media implements HasBrightness, Showable {
	/**
	 * Controllo della luminosità.
	 */
	private Control brightness;

	/**
	 * Costruttore.
	 * 
	 * @param title il titolo dell'immagine.
	 */
	public ImageMedia(String title) {
		super(title);
		this.brightness = new Control(0, 10, 5, '*');
	}

	@Override
	public Control getBrightnessControl() {
		return brightness;
	}
}

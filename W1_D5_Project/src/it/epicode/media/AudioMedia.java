package it.epicode.media;

/**
 * Un elemento audio.
 * 
 * @author Nello RIzzo
 *
 */
public abstract class AudioMedia extends PlayableMedia implements HasVolume {

	/**
	 * Memorizza il controllo del volume
	 */
	private final Control volume;

	/**
	 * Costruttore.
	 * 
	 * @param title    il titolo dell'audio.
	 * @param duration la durata dell'audio.
	 */
	public AudioMedia(String title, int duration) {
		super(title, duration);
		this.volume = new Control(0, 10, 5, '|');
	}

	/**
	 * Accede al controllo del volume.
	 */
	@Override
	public Control getVolumeControl() {
		return volume;
	}

}

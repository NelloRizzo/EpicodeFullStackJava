package it.epicode.media;

/**
 * Classe base per gli elementi multimediali riproducibili.
 * 
 * @author Nello Rizzo
 *
 */
public abstract class PlayableMedia extends Media implements Playable {

	/**
	 * Memorizza la durata.
	 */
	private final int duration;

	/**
	 * Costruttore.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	public PlayableMedia(String title, int duration) {
		super(title);
		this.duration = duration;
	}

	@Override
	public int getDuration() {
		return duration;
	}
}

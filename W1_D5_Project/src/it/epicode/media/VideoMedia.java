package it.epicode.media;

/**
 * Un video.
 * 
 * @author Nello Rizzo
 *
 */
public abstract class VideoMedia extends PlayableMedia implements HasBrightness, HasVolume {
	/**
	 * Memorizza il controllo del volume.
	 */
	private final Control volume;
	/**
	 * Memorizza il controllo della luminosità.
	 */
	private final Control brightness;

	/**
	 * Costruttore.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	public VideoMedia(String title, int duration) {
		super(title, duration);
		this.volume = new Control(0, 10, 5, '|');
		this.brightness = new Control(0, 10, 5, '*');
	}

	@Override
	public Control getVolumeControl() {
		return volume;
	}

	@Override
	public Control getBrightnessControl() {
		return brightness;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(super.toString());
		for (int i = 0; i < getDuration(); ++i) {
			sb.append(String.format("\n\t%s %s %s", getTitle(), volume, brightness));
		}
		return sb.toString();
	}
}

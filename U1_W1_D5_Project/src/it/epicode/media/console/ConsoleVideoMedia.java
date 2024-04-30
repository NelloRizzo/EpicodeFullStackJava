package it.epicode.media.console;

import it.epicode.media.VideoMedia;

/**
 * Un video che viene visualizzato in console.
 * 
 * @author Nello Rizzo
 *
 */
public class ConsoleVideoMedia extends VideoMedia {

	/**
	 * Costruttore.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	public ConsoleVideoMedia(String title, int duration) {
		super(title, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		StringBuilder sb = new StringBuilder().append(super.toString());
		for (int i = 0; i < getDuration(); ++i) {
			sb.append(String.format("\n\t%s %s %s", getTitle(), getVolumeControl(), getBrightnessControl()));
		}
		System.out.println(sb);
	}

}

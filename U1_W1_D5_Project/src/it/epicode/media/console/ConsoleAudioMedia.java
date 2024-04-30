package it.epicode.media.console;

import it.epicode.media.AudioMedia;

/**
 * Un audio che viene visualizzato in console.
 * @author Nello Rizzo
 *
 */
public class ConsoleAudioMedia extends AudioMedia {

	public ConsoleAudioMedia(String title, int duration) {
		super(title, duration);
	}

	@Override
	public void play() {
		StringBuilder sb = new StringBuilder().append(super.toString());
		for (int i = 0; i < getDuration(); ++i) {
			sb.append(String.format("\n\t%s %s", getTitle(), getVolumeControl()));
		}
		System.out.println(sb);
	}

}

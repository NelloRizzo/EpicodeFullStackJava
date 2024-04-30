package it.epicode.media.console;

import it.epicode.media.ImageMedia;

/**
 * Un'immagine che viene visualizzata in console.
 * 
 * @author Nello Rizzo
 *
 */
public class ConsoleImageMedia extends ImageMedia {

	public ConsoleImageMedia(String title) {
		super(title);
	}

	@Override
	public void show() {
		System.out.format("%s %s\n", super.toString(), getBrightnessControl());
	}

}

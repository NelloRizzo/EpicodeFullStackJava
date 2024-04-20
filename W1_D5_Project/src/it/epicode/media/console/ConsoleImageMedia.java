package it.epicode.media.console;

import it.epicode.media.ImageMedia;

public class ConsoleImageMedia extends ImageMedia {

	public ConsoleImageMedia(String title) {
		super(title);
	}

	@Override
	public void show() {
		System.out.format("%s %s\n", super.toString(), getBrightnessControl());
	}

}

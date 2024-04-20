package it.epicode.media;

public abstract class ImageMedia extends Media implements HasBrightness, Showable {

	private Control brightness;

	public ImageMedia(String title) {
		super(title);
		this.brightness = new Control(0, 10, 5, '*');
	}

	@Override
	public Control getBrightnessControl() {
		return brightness;
	}
}

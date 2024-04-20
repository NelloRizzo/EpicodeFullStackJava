package it.epicode.media;

public abstract class AudioMedia extends PlayableMedia implements HasVolume {

	private final Control volume;

	public AudioMedia(String title, int duration) {
		super(title, duration);
		this.volume = new Control(0, 10, 5, '|');
	}

	@Override
	public Control getVolumeControl() {
		return volume;
	}

}

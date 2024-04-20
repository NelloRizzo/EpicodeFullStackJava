package it.epicode.media;

public abstract class PlayableMedia extends Media implements Playable {

	private final int duration;

	public PlayableMedia(String title, int duration) {
		super(title);
		this.duration = duration;
	}

	@Override
	public int getDuration() {
		return duration;
	}
}

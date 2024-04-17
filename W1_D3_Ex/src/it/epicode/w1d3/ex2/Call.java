package it.epicode.w1d3.ex2;

public class Call {
	private int duration;
	private String number;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Call(int duration, String number) {
		super();
		this.duration = duration;
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("Call[duration=%d min., number=%s]", duration, number);
	}

}

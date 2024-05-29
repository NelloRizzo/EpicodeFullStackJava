package it.epicode.services;

public class Figure {
	private double widthInMeters;
	private double heightInMeters;

	public double getWidthInMeters() {
		return widthInMeters;
	}

	public double getHeightInMeters() {
		return heightInMeters;
	}

	public void setWidthInMeters(double widthInMeters) {
		this.widthInMeters = widthInMeters;
	}

	public void setHeightInMeters(double heightInMeters) {
		this.heightInMeters = heightInMeters;
	}

	public Figure(double widthInMeters, double heightInMeters) {
		this.widthInMeters = widthInMeters;
		this.heightInMeters = heightInMeters;
	}

	public Figure() {
	}

	@Override
	public String toString() {
		return String.format("Figure [widthInMeters=%s, heightInMeters=%s]", getWidthInMeters(), getHeightInMeters());
	}

}

package it.epicode;

public class MyFigure extends MyItem {
	private double wInch;
	private double hInch;

	public double getWidthInch() {
		return wInch;
	}

	public double getHeightInch() {
		return hInch;
	}

	public void setWidthInch(double wInch) {
		this.wInch = wInch;
	}

	public void setHeightInch(double hInch) {
		this.hInch = hInch;
	}

	public MyFigure(double wInch, double hInch) {
		this.wInch = wInch;
		this.hInch = hInch;
	}

	public MyFigure() {
	}

	@Override
	public String toString() {
		return String.format("MyFigure [width=%s in, height=%s in]", wInch, hInch);
	}

}

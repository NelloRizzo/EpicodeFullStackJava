package it.epicode;

import it.epicode.services.Figure;

public class FigureAdapter extends Figure {
	private MyFigure adaptee;

	public FigureAdapter(MyFigure adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public double getWidthInMeters() {
		return adaptee.getWidthInch() * .0254;
	}

	@Override
	public double getHeightInMeters() {
		return adaptee.getHeightInch() * .0254;
	}

}

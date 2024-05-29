package it.epicode.es2;

public abstract class Militare {

	private Militare responsabile;

	public Militare(Militare responsabile) {
		this.responsabile = responsabile;
	}

	public Militare getResponsabile() {
		return this.responsabile;
	}

	public abstract int getStipendio();

	public abstract void rispondiAlComando(int salarioMaggioreDi);
}

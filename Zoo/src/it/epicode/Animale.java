package it.epicode;

public abstract class Animale {
	protected String petName;

	public void comeTiChiami() {
		System.out.println("Mi chiamo " + petName);
	}

	public abstract void emettiVerso();
}

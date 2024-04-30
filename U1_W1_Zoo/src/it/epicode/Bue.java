package it.epicode;

public class Bue extends Erbivoro //
		implements InGradoDiEsibirsi {
	@Override
	public void emettiVerso() {
		System.out.println("Sono un bue e muggisco");
	}

	@Override
	public void faiQuelloCheSaiFare() {
		emettiVerso();
	}
}

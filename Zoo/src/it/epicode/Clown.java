package it.epicode;

public class Clown implements InGradoDiEsibirsi {
	public void esibisciti() {
		System.out.println("Faccio un gioco di prestigio...");
	}

	@Override
	public void faiQuelloCheSaiFare() {
		esibisciti();
	}
}

package it.epicode.w1d3.ex2;

import java.util.Arrays;

public class Sim {
	private String phone;
	private int credit;
	private Call[] calls;
	private int currentCall;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * @return le ultime chiamate effettuate
	 */
	public Call[] getCalls() {
		if (currentCall == 0)
			return new Call[0];
		// array che conterrà il risultato: il numero totale di chiamate registrate
		// potrà essere 5 o meno, in questo caso
		// mette solo quelle effettivamente effettuate
		Call[] calls = new Call[currentCall - 1];
		// copia le chiamate dall'array interno al risultato
		for (int i = 0; i < currentCall; ++i) {
			calls[i] = this.calls[i];
		}
		return calls;
	}

	/**
	 * Aggiunge una chiamata.
	 * 
	 * @param call la chiamata da aggiungere.
	 */
	public void addCall(Call call) {
		// se sono già state fatte 5 chiamate
		if (currentCall == 4) {
			// copia le ultime 4 scartando la prima
			for (int i = 0; i < 4; ++i) {
				this.calls[i] = this.calls[i + 1];
			}
		}
		// aggiunge la chiamata
		calls[currentCall] = call;
		// se sono state effettuate meno di 5 chiamate
		if (currentCall < 4)
			++currentCall;
	}

	public Sim(String phone) {
		this.phone = phone;
		credit = 0;
		calls = new Call[5];
		currentCall = 0;
	}

	public String toString() {
		var duration = 0;
		for (int i = 0; i < currentCall; ++i)
			duration += calls[i].getDuration();
		return String.format("Sim[phone=%s, credit=%d, totalDuration=%d, calls=%s]", phone, credit, duration,
				Arrays.toString(calls));
	}
}

package it.epicode.code;

public class Volontario implements PuoIniziareALavorare {
	String nome;
	int eta;
	String cv;

	public Volontario(String nome, int eta, String cv) {
		this.nome = nome;
		this.eta = eta;
		this.cv = cv;
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}

	public String getCv() {
		return cv;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	@Override
	public void checkIn() {
		System.out.println("Il volontario " + nome + " inizia a lavorare");
	}
}

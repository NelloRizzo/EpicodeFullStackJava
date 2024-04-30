package it.epicode.code;

public abstract class Dipendente implements PuoIniziareALavorare {

	public abstract float calculateSalary();

	private String matricola;
	private float stipendio;
	private Dipartimento dipartimento;

	public String getMatricola() {
		return matricola;
	}

	public float getStipendio() {
		return stipendio;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Dipendente(String matricola, float stipendio, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.dipartimento = dipartimento;
	}

	@Override
	public void checkIn() {
		System.out.println("Il dipendente con matricola " + matricola + " inizia a lavorare");
	}
}

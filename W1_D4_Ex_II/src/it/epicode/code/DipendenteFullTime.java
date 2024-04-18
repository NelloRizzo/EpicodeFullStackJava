package it.epicode.code;

public class DipendenteFullTime extends Dipendente{

	public DipendenteFullTime(String matricola, float stipendio, Dipartimento dipartimento) {
		super(matricola, stipendio, dipartimento);
	}

	@Override
	public float calculateSalary() {
		return getStipendio();
	}

}

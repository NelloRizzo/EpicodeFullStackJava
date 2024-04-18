package it.epicode.code;

public class DipendentePartTime extends Dipendente {

	private int oreLavorate;
	private float pagaOraria;

	public int getOreLavorate() {
		return oreLavorate;
	}

	public void setOreLavorate(int oreLavorate) {
		this.oreLavorate = oreLavorate;
	}

	public float getPagaOraria() {
		return pagaOraria;
	}

	public void setPagaOraria(float pagaOraria) {
		this.pagaOraria = pagaOraria;
	}

	public DipendentePartTime(String matricola, int oreLavorate, float pagaOraria, Dipartimento dipartimento) {
		super(matricola, oreLavorate * pagaOraria, dipartimento);
		this.oreLavorate = oreLavorate;
		this.pagaOraria = pagaOraria;
	}

	@Override
	public float calculateSalary() {
		return oreLavorate * pagaOraria;
	}

}

package it.epicode.es2;

public class Maggiore extends Militare{

	public Maggiore(Militare responsabile) {
		super(responsabile);
	}

	@Override
	public int getStipendio() {
		return 3000;
	}

	@Override
	public void rispondiAlComando(int salarioMaggioreDi) {
		if (getStipendio() > salarioMaggioreDi)
			System.out.println("Sono un maggiore e ho un salario di " + getStipendio());
		if (getResponsabile() != null)
			getResponsabile().rispondiAlComando(salarioMaggioreDi);
	}}

package it.epicode.es2;

public class Capitano extends Militare {

	public Capitano(Militare responsabile) {
		super(responsabile);
	}

	@Override
	public int getStipendio() {
		return 2000;
	}

	@Override
	public void rispondiAlComando(int salarioMaggioreDi) {
		if (getStipendio() > salarioMaggioreDi)
			System.out.println("Sono un capitano e ho un salario di " + getStipendio());
		if (getResponsabile() != null)
			getResponsabile().rispondiAlComando(salarioMaggioreDi);
	}
	
}

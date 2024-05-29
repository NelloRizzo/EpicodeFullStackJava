package it.epicode.es2;

public class Tenente extends Militare {

	public Tenente(Militare responsabile) {
		super(responsabile);
	}

	@Override
	public int getStipendio() {
		return 1000;
	}

	@Override
	public void rispondiAlComando(int salarioMaggioreDi) {
		if (getStipendio() > salarioMaggioreDi)
			System.out.println("Sono un tenente e ho un salario di " + getStipendio());
		if (getResponsabile() != null)
			getResponsabile().rispondiAlComando(salarioMaggioreDi);
	}

}

package it.epicode.es2;

public class Program {

	public static void main(String[] args) {
		Maggiore m = new Maggiore(null);
		Capitano c = new Capitano(m);
		Tenente t = new Tenente(c);
		
		t.rispondiAlComando(2000);
	}

}

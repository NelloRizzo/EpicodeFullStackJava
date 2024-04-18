package it.epicode.classes;

public class DerivedClass extends BaseClass {

	public void doOther() {
		this.pub = 20;
		this.prot = 10;
		System.out.println("Ciao da DerivedClass");
	}
	// ridefinizione in overloading (sovraccaricamento)
	public void doIt(int multiplier) {
		this.prot *= multiplier;
		this.pub *= multiplier;
		doIt();
	}
	// ridefinizione in overriding (sovrascrittura)
	// specializzazione (modifica del comportamento)
	public void doIt() {
		System.out.println("doIt() di Derived");
		// super -> si riferisce alla superclasse
		// superclasse -> classe di livello superiore -> classe base
		super.doIt();
	}
}

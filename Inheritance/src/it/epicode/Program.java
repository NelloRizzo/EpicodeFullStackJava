package it.epicode;

import it.epicode.classes.BaseClass;
import it.epicode.classes.DerivedClass;

public class Program {

	public static void handle(BaseClass b) {
		System.out.print("Metodo handle: ");
		b.doIt();
	}

	public static void main(String[] args) {
		BaseClass b = new BaseClass();
		//b.doIt();

		DerivedClass d = new DerivedClass();
//		d.doOther();
//		d.doIt();
//		d.pub = 45;
//		d.doIt();
//		d.doIt(10);

		handle(b);
		handle(d);
	}
}

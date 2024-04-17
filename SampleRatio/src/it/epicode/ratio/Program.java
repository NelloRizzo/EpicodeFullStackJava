package it.epicode.ratio;

public class Program {

//	
//	 Abbiamo la necessità di <effettuare operazioni aritmetiche> che coinvolgano
//	 le [frazioni aritmetiche].
//	 
//	 Cosa si intende per "frazione aritmetica"?
//	 Una [frazione] è caratterizzata da [un segno], [un numeratore] e [un denominatore].
//	 Il segno è + o -.
//	 Il numeratore è un intero non negativo.
//	 Il denominatore è un intero positivo.
//	 
//	 Esempio: -1/3, 3/4, 3 (in realtà è 3/1)...
//	 
//	 +--------------------------------+
//	 | Ratio                          |
//	 +------------------------+-------+
//	 |  signum                |   N   | (segno + = +1, segno - = -1)
//	 |  numerator			  |   N   |
//	 |  denominator			  |   N   |
//	 +------------------------+-------+
//	 | asString()    -> String        |
//	 | add(Ratio)    -> Ratio         |
//	 +--------------------------------+
//	 
	public static void main(String[] args) {
		Ratio r1 = new Ratio();
		r1.numerator = 3;
		r1.denominator = 4;
		r1.signum = -1;
		System.out.println(r1.signum + " " + r1.numerator + "/" + r1.denominator);
		System.out.println(r1.asString());
		Ratio r2 = new Ratio(1,-3);
		System.out.println(r2.asString());
		Ratio r3 = new Ratio(0.5f);
		System.out.println(r3.asString());
		Ratio r4 = r2.add(r3);
		System.out.println(r4.asString());
		
		System.out.println(Ratio.half.asString());
		
		Ratio a = new Ratio(1,2);
		Ratio b = new Ratio(1,2);
		System.out.println(a.asString());
		System.out.println(b.asString());
		if (a == b) 
			System.out.println("a e b sono uguali");
		else
			System.out.println("a e b sono diversi");
	}

}

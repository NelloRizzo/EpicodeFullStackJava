package it.epicode;

public class Program {

	static void incrementa(int x) {
		System.out.println("In ingresso x vale " + x);
		x++;
		System.out.println("All'uscita x vale " + x);
	}
	
	static void incrementa(My m) {
		System.out.println("In ingresso m vale " + m.asString());
		m.setValue(m.getValue()+1);
		System.out.println("All'uscita m vale " + m.asString());
	}
	public static void main(String[] args) {
//		My my = new My(10);
//		System.out.println(my.asString());
//		{
//			System.out.println(my.asString());
//			My my2 = new My(20);
//			System.out.println(my2.asString());
//		}
//		System.out.println(my.asString());
//		System.out.println(my2.asString());
		int i = 0;
		System.out.println("Prima di invocare 'incrementa' i vale " + i);
		incrementa(i);
		System.out.println("Dopo l'invocazione di 'incrementa' i vale " + i);
		My my = new My(0);
		System.out.println("Prima di invocare 'incrementa' my vale " + my.asString());
		incrementa(my);
		System.out.println("Dopo l'invocazione di 'incrementa' my vale " + my.asString());
	}

}

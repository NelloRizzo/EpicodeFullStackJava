package it.epicode;

public class Program {

	public static void main(String[] args) {
		My m1 = new My("Nello");
		My m2 = new My(10);
		
		System.out.println(m1);
		System.out.println(m2);
		
		m1.setValue(1.234);
		System.out.println(m1);
		
		GenericMy<String> g1 = new GenericMy<String>("Nello");
		System.out.println(g1);
		//g1.setValue(1.234);
		GenericMy<Integer> g2 = new GenericMy<Integer>(10);
		System.out.println(g2);
		//g2.setValue("Nello");
		
		GenericMy<B> b = new GenericMy<B>(new D("Archimede", "dott."));
		System.out.println(b);
	}
}

package it.epicode.classes;

public class BaseClass {

	private int priv = 1;
	protected int prot = 2;
	public int pub = 3;

	public void doIt() {
		System.out.println("doIt() di BaseClass");
		System.out.println("priv vale: " + priv);
		System.out.println("prot vale: " + prot);
		System.out.println("pub vale: " + pub);
	}
}

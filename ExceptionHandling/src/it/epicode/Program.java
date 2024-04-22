package it.epicode;

import java.io.File;

public class Program {

	public static int divide(int a, int b) {
		return a / b;
	}

//	public static void sample() {
//		var f = File.createTempFile("p", "s");
//	}
	
	public static void main(String[] args) {
		System.out.println(divide(10, 5));
		System.out.println(divide(5, 0));
		
	}

}

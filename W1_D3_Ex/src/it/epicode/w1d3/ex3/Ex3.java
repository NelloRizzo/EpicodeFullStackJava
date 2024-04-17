package it.epicode.w1d3.ex3;

import java.time.LocalDate;

public class Ex3 {

	public static void execute() {
		Product pc = new Product("0001", "PC", 1000, 2);
		Product mouse = new Product("0002", "Mouse", 15, 100);
		Customer me = new Customer("0001", "Nello Rizzo", "nellorizzo@live.it", LocalDate.now());
		Cart cart = new Cart(me, new Product[] { pc, mouse, pc, mouse });
		System.out.println(cart);
	}
}

package it.epicode.w1d3;

import java.util.Scanner;

import it.epicode.w1d3.ex1.Ex1;
import it.epicode.w1d3.ex2.Ex2;
import it.epicode.w1d3.ex3.Ex3;

public class Program {

	static Scanner scanner = new Scanner(System.in);
	
	static int menu(String[] items) {
		System.out.println("***** MENU *****");
		for (int i = 0; i < items.length; ++i) {
			System.out.print(i + 1);
			System.out.println(".\t" + items[i]);
		}
		System.out.println("0.\tEsci");
		int choice;
		do {
			System.out.print("Scegli: ");
			try {
				choice = scanner.nextInt();
			} catch (Exception ex) {
				System.out.println("Attenzione, devi scrivere un numero...");
				choice = -1;
			}
		} while (choice < 0 && choice > items.length);
		return choice;
	}

	public static void main(String[] args) {
		String[] menuItems = { "Esercizio 1", "Esercizio 2", "Esercizio 3" };
		int choice;
		while ((choice = menu(menuItems)) != 0) {
			switch (choice) {
			case 1:
				Ex1.main();
				break;
			case 2:
				Ex2.main();
				break;
			case 3:
				Ex3.main();
				break;
			}
		}
		System.out.println("Fine.");
	}
}

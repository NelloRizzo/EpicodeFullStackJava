package it.epicode;

import java.util.InputMismatchException;
import java.util.Scanner;

import it.epicode.ex1.Ex1;
import it.epicode.ex2.Ex2;
import it.epicode.ex3.Ex3;

public class Program {

	private static Executable[] items = { new Ex1(5), new Ex2(), new Ex3() };

	private static Scanner scanner = new Scanner(System.in);

	public static void title(Executable item) {
		String title = item.getClass().getSimpleName();
		System.out.println("*".repeat(title.length() + 4));
		System.out.println("  " + title);
		System.out.println("*".repeat(title.length() + 4));
	}

	public static void menu(Executable[] items) {
		boolean running = true;
		while (running) {
			System.out.println("***** Menu *****");
			int count = 0;
			for (var i : items) {
				System.out.format("%d\t%s%n", ++count, i.getClass().getSimpleName());
			}
			System.out.println("0.\tEsci");
			try {
				System.out.print("Scegli: ");
				int choice = scanner.nextInt();
				if (choice == 0)
					running = false;
				else {
					title(items[choice - 1]);
					items[choice - 1].execute();
				}
			} catch (InputMismatchException e) {
				System.out.println("Devi scrivere un numero intero");
				scanner.nextLine();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Hai selezionato una voce inesistente!");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String[] args) {
		menu(items);
		System.out.println("Fine.");
	}
}

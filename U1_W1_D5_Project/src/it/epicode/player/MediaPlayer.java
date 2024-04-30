package it.epicode.player;

import java.util.Scanner;

import it.epicode.media.Media;
import it.epicode.media.Playable;
import it.epicode.media.Showable;

/**
 * Una implementazione di un mediaplayer.
 * 
 * @author Nello Rizzo
 *
 */
public class MediaPlayer {

	/**
	 * Memorizza gli elementi multimediali.
	 */
	private final Media[] media;

	/**
	 * Costruttore.
	 * 
	 * @param media gli elementi multimediali da riprodure.
	 */
	public MediaPlayer(Media[] media) {
		this.media = media;
	}

	/**
	 * Mostra il menu e riproduce.
	 * 
	 * @param scanner serve per l'input da tastiera.
	 */
	public void menu(Scanner scanner) {
		int count = media.length;
		for (int i = 0; i < count; ++i) {
			System.out.format("%d.\t%s\n", i + 1, media[i].getTitle());
		}
		System.out.println("0.\tEsci");

		boolean running = true;
		while (running) {
			int choice;
			do {
				System.out.print("Scegli cosa riprodurre: ");
				choice = scanner.nextInt();
			} while (choice < 0 || choice > count);
			if (choice == 0)
				running = false;
			else {
				Media m = media[choice - 1];
				if (m instanceof Showable)
					((Showable) m).show();
				else if (m instanceof Playable)
					((Playable) m).play();
				else
					System.out.println("Tipo di elemento multimediale non supportato");
			}
		}
	}
}

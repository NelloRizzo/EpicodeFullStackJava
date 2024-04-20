package it.epicode;

import java.util.Scanner;

import it.epicode.media.AudioMedia;
import it.epicode.media.ImageMedia;
import it.epicode.media.Media;
import it.epicode.media.VideoMedia;
import it.epicode.media.console.ConsoleAudioMedia;
import it.epicode.media.console.ConsoleImageMedia;
import it.epicode.media.console.ConsoleVideoMedia;
import it.epicode.player.MediaPlayer;

public class Program {

	public static void main(String[] args) {
		AudioMedia a1 = new ConsoleAudioMedia("Il caffé della Peppina", 3);
		AudioMedia a2 = new ConsoleAudioMedia("L'inno di Mameli", 4);
		VideoMedia v1 = new ConsoleVideoMedia("Il pianeta delle scimmie", 3);
		VideoMedia v2 = new ConsoleVideoMedia("The Beekeper", 2);
		ImageMedia i1 = new ConsoleImageMedia("Il Colosseo");
		a1.getVolumeControl().up();
		a1.getVolumeControl().up();
		a1.getVolumeControl().up();
		a2.getVolumeControl().down();
		a2.getVolumeControl().down();
		a2.getVolumeControl().down();
		v1.getVolumeControl().up();
		v1.getBrightnessControl().up();
		v1.getBrightnessControl().up();
		v2.getBrightnessControl().down();
		v2.getBrightnessControl().down();
		v2.getVolumeControl().down();
		i1.getBrightnessControl().up();
		i1.getBrightnessControl().up();
		i1.getBrightnessControl().up();
		Media[] media = { a1, a2, v1, v2, i1 };

		MediaPlayer player = new MediaPlayer(media);
		Scanner scanner = new Scanner(System.in);
		player.menu(scanner);

	}

}

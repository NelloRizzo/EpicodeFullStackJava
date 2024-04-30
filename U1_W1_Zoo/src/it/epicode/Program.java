package it.epicode;

public class Program {

//	In uno zoo sono ospitati diversi animali.
//	Ogni [animale] può essere [erbivoro], [carnivoro] o [onnivoro], ecc...
//	Inoltre ogni animale può <emettere un verso>.
//	Costruire un sistema che sia in grado di emulare uno zoo facendo emettere 
//	il verso opportuno ad ognuno degli animali ospitati.
//	
//	Animale
//	  +--- emettiVerso()
//	Animale Erbivoro
//	  +--- emettiVerso()
//	Animale Carnivoro
//	  +--- emettiVerso()
//	Animale Onnivoro
//	  +--- emettiVerso()

	public static void zooSystem(Animale[] a) {
		System.out.println("Uno zoo di animali");
		for (int i = 0; i < a.length; ++i) {
			a[i].emettiVerso();
		}
	}

	// lo zoo deve far esibire anche dei clown
	// NELLO STESSO SISTEMA PRECEDENTE!!!!
//	RegolaDiEsibizione {
//		void faiQuelloCheSaiFare();
//	}
	public static void zooSystem(InGradoDiEsibirsi[] e) {
		System.out.println("Uno zoo con clowns");
		for (int i = 0; i < e.length; ++i) {
			e[i].faiQuelloCheSaiFare();
		}
	}

	public static void main(String[] args) {
		// Animale a1 = new Animale();
		// Erbivoro e1 = new Erbivoro();
		Bue b = new Bue();
		b.petName = "Orazio";
		b.comeTiChiami();
		Cammello c = new Cammello();
		zooSystem(new Animale[] { b, c });
		zooSystem(new InGradoDiEsibirsi[] { new Clown(), b });
	}

}

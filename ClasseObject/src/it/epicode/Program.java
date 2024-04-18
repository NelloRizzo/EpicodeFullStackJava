package it.epicode;

public class Program {

	// inner class
	public static class My {
		int value;

		public My(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "My(" + value + ")";
		}

		@Override
		public boolean equals(Object obj) {
			// my -> this
			// instanceof controlla che l'oggetto obj passato
			// sia effettivamente di classe My
			if (obj instanceof My) {
				// se sono qui obj E' DI CLASSE My
				// quindi posso fare una conversione:
				//        (cast) da Object verso My
				My other = (My) obj;
				// il cast CONVERTE Object in My
				// da questo momento in poi
				// dentro other ci sarà il contenuto di obj
				// GUARDATO dal punto di vista di My
				// a questo punto posso controllare l'uguaglianza
				// tra gli attributi di due oggetti di classe My
				boolean uguali = this.value == other.value;
				if (uguali)
					return true;
				else
					return false;
			} else
				return false;
		}
	}

	public static class Mine extends My {
		int value2;

		public Mine(int value, int value2) {
			super(value);
			this.value2 = value2;
		}

		@Override
		public String toString() {
			return "Mine(" + super.toString() + "," + value2 + ")";
		}
	}

	public static void main(String[] args) {
		My my = new My(10);
		System.out.println(my);
		Mine m = new Mine(10, 20);
		System.out.println(m);
		My other = new My(10);
		System.out.println(other);
		if (my == other)
			System.out.println("my e other sono uguali");
		else
			System.out.println("my e other sono diversi");
		if (my.equals(other))
			System.out.println("my e other sono uguali");
		else
			System.out.println("my e other sono diversi");
	}
}

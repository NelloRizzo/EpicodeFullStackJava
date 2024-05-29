package it.epicode;

public class Program {

	private static class Image extends BookItem {

		private String name;

		public Image(String name) {
			this.name = name;
		}

		@Override
		protected void print(int indent) {
			System.out.format("%sImmagine: %s\n", "\t".repeat(indent), name);
		}

	}

	/*
	 * Un libro è composto da pagine singole o organizzate in sezioni. Ogni sezione
	 * può contenere altre sottosezioni o pagine semplici.
	 */
	public static void main(String[] args) {
		Book book = new Book();
		book.addContent(new PageItem("Pagina 1"));

		var p1 = new PageItem("Pagina 1 - Sezione 1");
		var p2 = new PageItem("Pagina 2 - Sezione 1");
		var p3 = new PageItem("Pagina 1 - Sezione 2");

		var s1 = new SectionItem("Sezione 1");
		s1.addItem(new Image("Esempio di immagine"));
		s1.addItem(p1);
		s1.addItem(p2);
		var s2 = new SectionItem("Sezione 2");
		s2.addItem(p3);

		var ss1 = new SectionItem("Sottosezione 1");
		ss1.addItem(new PageItem("Pagina 1 - Sottosezione 1"));
		s1.addItem(ss1);

		book.addContent(s1);
		book.addContent(s2);
		book.addContent(new PageItem("Ultima pagina"));

		book.printBook();
	}

}

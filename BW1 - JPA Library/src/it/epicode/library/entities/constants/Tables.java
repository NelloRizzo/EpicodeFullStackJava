package it.epicode.library.entities.constants;

public class Tables {
	// inner class
	public static class Names {
		public static final String LIBRARY_BASE = "library";
		public static final String BOOKS = "books";
		public static final String MAGAZINES = "magazines";
	}

	public static class Columns {
		public static final String DISCRIMINATOR = "data_type";
	}

	public static class Discriminators {
		public static final String BOOKS = "0";
		public static final String MAGAZINES = "1";
	}
}

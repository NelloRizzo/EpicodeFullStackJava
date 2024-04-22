package it.epicode.oop;

public class Persona {
	private String nome;
	private String cognome;
	private Gender gender = Gender.Male;
	private int numeroFigli;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getNumeroFigli() {
		return numeroFigli;
	}

	// Setter
	public void setNumeroFigli(int n) {
		try {
			if (n < 0)
				throw new NumeroFigliNegativoException();
			numeroFigli = n;
		} finally {
			System.out.println("Questa istruzione è fondamentale per il funzionametno del sistema");
		}
	}

	public Persona(String n, String c) {
		this(n, c, Gender.Male);
	}

	public Persona(String n, String c, Gender g) {
		if (n.length() == 0)
			throw new NomeNulloException();
		nome = n;
		if (c.length() == 0)
			throw new CognomeNulloException();
		cognome = c;
		gender = g;
	}

	public void presentaTeStesso() {
		System.out.print("Mi chiamo " + nome + " " + cognome);
		System.out.println(" e sono: " + (gender == Gender.Male ? "uomo" : "donna"));
	}

	@Override
	public String toString() {
		return String.format("Persona [nome=%s, cognome=%s, gender=%s, numeroFigli=%s]", nome, cognome, gender,
				numeroFigli);
	}

}

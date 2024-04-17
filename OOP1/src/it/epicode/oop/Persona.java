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
		if (n < 0)
			n = -n;
		numeroFigli = n;
	}

	public Persona() {
		nome = "N/A";
		cognome = "N/A";
	}

	public Persona(String n, String c) {
		System.out.println("Costruttore di Persona");
		nome = n;
		cognome = c;
	}

	public Persona(String n, String c, Gender g) {
		System.out.println("Costruttore di Persona");
		nome = n;
		cognome = c;
		gender = g;
	}

	public void presentaTeStesso() {
		System.out.print("Mi chiamo " + nome + " " + cognome);
		System.out.println(" e sono: " + (gender == Gender.Male ? "uomo" : "donna"));
	}
}

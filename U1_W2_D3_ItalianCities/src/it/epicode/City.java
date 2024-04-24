package it.epicode;

public class City {
	private String name;
	private String acronym;

	public String getName() {
		return name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public City(String name, String acronym) {
		this.name = name;
		this.acronym = acronym;
	}

	@Override
	public String toString() {
		return String.format("City [name=%s, acronym=%s]", name, acronym);
	}

}

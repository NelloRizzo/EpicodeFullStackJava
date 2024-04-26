package it.epicode.data;

public class City {
	public Long id;
	private String name;
	private String acronym;
	private String province;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public City(Long id, String name, String acronym, String province) {
		this.name = name;
		this.acronym = acronym;
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City(id=%d, name=%s, province=%s, acronym=%s)", name, province, acronym);
	}
}

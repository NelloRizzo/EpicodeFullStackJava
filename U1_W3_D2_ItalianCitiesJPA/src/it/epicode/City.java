package it.epicode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 2, nullable = false)
	private String acronym;
	@Column(length = 80, nullable = false)
	private String province;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setId(long id) {
		this.id = id;
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

	public City() {
	}

	public City(String name, String acronym, String province) {
		this.name = name;
		this.acronym = acronym;
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City [name=%s, province=%s, acronym=%s]", name, province, acronym);
	}
}

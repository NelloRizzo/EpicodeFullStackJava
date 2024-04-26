package it.epicode.data;

<<<<<<< HEAD
public class City {
	public Long id;
=======

import java.util.Objects;

public class City implements Comparable<City> {
>>>>>>> 384e3cece4dc783d9225432567bacf9c3ec863b1
	private String name;
	private String acronym;
	private String province;

<<<<<<< HEAD
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

=======
>>>>>>> 384e3cece4dc783d9225432567bacf9c3ec863b1
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

<<<<<<< HEAD
=======
	public City(String name, String acronym, String province) {
		this.name = name;
		this.acronym = acronym;
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City [name=%s, province=%s, acronym=%s]", name, province, acronym);
	}

>>>>>>> 384e3cece4dc783d9225432567bacf9c3ec863b1
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

<<<<<<< HEAD
	public City(String name, String acronym, String province) {
		this.name = name;
		this.acronym = acronym;
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City [name=%s, province=%s, acronym=%s]", name, province, acronym);
	}
=======
	@Override
	public int compareTo(City o) {
		var c = this.province.compareTo(o.province);
		return c == 0 ? this.name.compareTo(o.name) : c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(province, name);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof City && obj.hashCode() == hashCode();
	}

>>>>>>> 384e3cece4dc783d9225432567bacf9c3ec863b1
}

package it.epicode.entities;

import it.epicode.entities.constants.Queries;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = Queries.Cities.ALL, query = "SELECT c FROM City c")
@NamedQuery(name = Queries.Cities.BY_PROVINCE, query = "SELECT c FROM City c WHERE c.province.acronym = :acronym")
@NamedQuery(name = Queries.Cities.BY_ID, query = "SELECT c FROM City c WHERE c.id = :id")
@NamedQuery(name = Queries.Cities.COUNT_BY_PROVINCE, query = "SELECT c.province.name, COUNT(c.id) FROM City c GROUP BY c.province.name ORDER BY c.province.name")
@NamedQuery(name = Queries.Cities.COUNT, query = "SELECT COUNT(c.id) FROM City c")
public class City extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 4, nullable = false)
	private String cadastral;
	private boolean capital;
	@ManyToOne
	private Province province;

	public City(String name, String cadastral, boolean capital, Province province) {
		this.name = name;
		this.cadastral = cadastral;
		this.capital = capital;
		this.province = province;
	}

	public City() {
	}

	public String getName() {
		return name;
	}

	public String getCadastral() {
		return cadastral;
	}

	public boolean isCapital() {
		return capital;
	}

	public Province getProvince() {
		return province;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCadastral(String cadastral) {
		this.cadastral = cadastral;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public City setProvince(Province province) {
		this.province = province;
		return this;
	}

	@Override
	public String toString() {
		return String.format("City[id=%d, name=%s, cadastral=%s, capital=%s, province=%s]", getId(), name, cadastral,
				capital, province);
	}

}

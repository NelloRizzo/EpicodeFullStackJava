package it.epicode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
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

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City[id=%d, name=%s, cadastral=%s, capital=%s, province=%s]", getId(), name, cadastral,
				capital, province);
	}

}

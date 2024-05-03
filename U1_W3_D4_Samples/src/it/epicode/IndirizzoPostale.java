package it.epicode;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class IndirizzoPostale extends Recapito {
	@Column(length = 125, nullable = true)
	private String via;
	@Column(length = 15, nullable = true)
	private String numero;
	@Column(length = 80, nullable = true)
	private String citta;
	@Column(length = 5, nullable = true)
	private String cap;
	@Column(length = 2, nullable = true)
	private String provincia;

	public IndirizzoPostale(boolean lavoro, String via, String numero, String citta, String cap, String provincia) {
		super(lavoro);
		this.via = via;
		this.numero = numero;
		this.citta = citta;
		this.cap = cap;
		this.provincia = provincia;
	}

	public IndirizzoPostale() {
	}

	public String getVia() {
		return via;
	}

	public String getNumero() {
		return numero;
	}

	public String getCitta() {
		return citta;
	}

	public String getCap() {
		return cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return String.format("IndirizzoPostale[id=%s, via=%s, numero=%s, citta=%s, cap=%s, provincia=%s, lavoro=%s]",
				getId(), via, numero, citta, cap, provincia, isLavoro());
	}

}

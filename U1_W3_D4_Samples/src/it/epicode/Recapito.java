package it.epicode;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_di_dato", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "TUTTI_I_RECAPITI", query = "SELECT r FROM Recapito r ORDER BY r.id")
@NamedQuery(name = "RECAPITO_PER_TIPOLOGIA", //
		query = "SELECT r FROM Recapito AS r WHERE lavoro = :lavorativo")
public abstract class Recapito {
	@Id
	@GeneratedValue
	private long id;
	private boolean lavoro;

	public Recapito() {
	}

	public Recapito(boolean lavoro) {
		this.lavoro = lavoro;
	}

	public long getId() {
		return id;
	}

	public boolean isLavoro() {
		return lavoro;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLavoro(boolean lavoro) {
		this.lavoro = lavoro;
	}
}

package it.epicode.bw1.transportcompany.entities.tickets;

import java.time.LocalDateTime;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = C.Names.DISCRIMINATOR_COLUMN, discriminatorType = DiscriminatorType.INTEGER)
@NamedQuery(name = C.T.TravelDocument.Queries.SELECT_ALL, query = "SELECT td FROM TravelDocument td")
@NamedQuery(name = C.T.TravelDocument.Queries.DOCUMENTS_BY_PERIOD, //
		query = "SELECT td FROM TravelDocument td WHERE td.issuedAt BETWEEN :from AND :to ORDER BY td.issuedAt")
@NamedQuery(name = C.T.TravelDocument.Queries.DOCUMENTS_BY_PERIOD_AND_RESELLER, //
		query = "SELECT td FROM TravelDocument td WHERE td.issuedAt BETWEEN :from AND :to AND td.issuedBy = :reseller ORDER BY td.issuedAt")
public abstract class TravelDocument extends BaseEntity {
	@Column(length = 25, nullable = false)
	private String number;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Reseller issuedBy;
	@Column(nullable = false)
	private LocalDateTime issuedAt;

	public TravelDocument() {
	}

	public TravelDocument(String number, Reseller issuedBy, LocalDateTime issuedAt) {
		this.number = number;
		this.issuedBy = issuedBy;
		this.issuedAt = issuedAt;
	}

	public String getNumber() {
		return number;
	}

	public Reseller getIssuedBy() {
		return issuedBy;
	}

	public LocalDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setIssuedBy(Reseller issuedBy) {
		this.issuedBy = issuedBy;
	}

	public void setIssuedAt(LocalDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	@Override
	public String toString() {
		return String.format("TravelDocument(number=%s, issuedBy=%s, issuedAt=%s, %s)", number, issuedBy, issuedAt,
				super.toString());
	}

}

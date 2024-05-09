package it.epicode.bw1.transportcompany.entities.fleet;

import java.time.LocalDateTime;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = C.T.Mantenance.Queries.SELECT_IN_MANTENANCE, query = "SELECT m FROM Mantenance m WHERE m.end_recovery IS NULL")
@NamedQuery(name = C.T.Mantenance.Queries.SELECT_IN_SERVICE, query = "SELECT m FROM Mantenance m WHERE m.end_recovery IS NOT NULL")
@NamedQuery(name = C.T.Mantenance.Queries.SELECT_ALL, query = "SELECT m FROM Mantenance m")
@NamedQuery(name = C.T.Mantenance.Queries.SELECT_MANTENANCE_VEHICLE, query = "SELECT m FROM Mantenance m WHERE m.vehicle = :vehicle AND m.end_recovery IS NULL")
public class Mantenance extends BaseEntity {
	@ManyToOne
	private Vehicle vehicle;
	@Column(nullable = false)
	private LocalDateTime start_recovery;
	@Column(nullable = true)
	private LocalDateTime end_recovery;

	public Mantenance() {
	}

	public Mantenance(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
		this.vehicle = vehicle;
		this.start_recovery = start;
		this.end_recovery = end;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public LocalDateTime getStart() {
		return start_recovery;
	}

	public LocalDateTime getEnd() {
		return end_recovery;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setStart(LocalDateTime start) {
		this.start_recovery = start;
	}

	public void setEnd(LocalDateTime end) {
		this.end_recovery = end;
	}

	@Override
	public String toString() {
		return String.format("Maintenance(vehicle=%s, start=%s, end=%s, %s)", vehicle, start_recovery, end_recovery,
				super.toString());
	}

}

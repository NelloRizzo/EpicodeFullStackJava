package it.epicode.bw1.transportcompany.entities.routes;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.fleet.Vehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleRoute extends BaseEntity {
	@ManyToOne
	private Vehicle vehicle;
	@ManyToOne
	private Route route;
	private int minutes;

	public VehicleRoute() {
	}

	public VehicleRoute(Vehicle vehicle, Route route, int minutes) {
		this.vehicle = vehicle;
		this.route = route;
		this.minutes = minutes;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Route getRoute() {
		return route;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return String.format("VehicleRoute(vehicle=%s, route=%s, minutes=%s, %s)", vehicle, route, minutes,
				super.toString());
	}

}

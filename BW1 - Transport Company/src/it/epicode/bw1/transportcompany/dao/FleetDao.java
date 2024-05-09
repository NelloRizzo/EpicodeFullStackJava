package it.epicode.bw1.transportcompany.dao;

import java.util.List;
import java.util.Optional;

import it.epicode.bw1.transportcompany.entities.fleet.Mantenance;
import it.epicode.bw1.transportcompany.entities.fleet.Vehicle;

public interface FleetDao extends Dao<Vehicle> {

	List<Mantenance> getInMantenance();

	List<Mantenance> getInService();

	Optional<Vehicle> getVechicleInMantenance(Vehicle v);

	void setInMantenance(Vehicle v);

	void setInService(Vehicle v);
}

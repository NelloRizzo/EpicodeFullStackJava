package it.epicode.w2d3.fines.services;

import java.time.LocalDateTime;
import java.util.List;

import it.epicode.w2d3.fines.entities.Fine;
import it.epicode.w2d3.fines.entities.Vehicle;

public interface FineService {

	Vehicle register(Vehicle v);

	Fine emit(Long vehicleId, Fine data);

	List<Fine> getByDates(LocalDateTime start, LocalDateTime end);

	List<Fine> getByVehicle(Long vehicleId);

	Vehicle getVehicleByPlate(String plate);
}

package it.epicode.w2d3.fines.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import it.epicode.w2d3.fines.entities.Fine;
import it.epicode.w2d3.fines.entities.Vehicle;
import it.epicode.w2d3.fines.repositories.FinesRepository;
import it.epicode.w2d3.fines.repositories.VehiclesRepository;
import it.epicode.w2d3.fines.services.exceptions.DuplicateKeyAppException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FineServiceImpl implements FineService {

	@Autowired
	FinesRepository finesRepo;

	@Autowired
	VehiclesRepository vehiclesRepo;

	@Override
	public Vehicle register(Vehicle v) {
		try {
			return vehiclesRepo.save(v);
		} catch (DataIntegrityViolationException e) {
			log.error(String.format("Chiave duplicata: %s", v.getPlate()), e);
			throw new DuplicateKeyAppException(v.getPlate());
		}
	}

	@Override
	public Fine emit(Long vehicleId, Fine data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fine> getByDates(LocalDateTime start, LocalDateTime end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fine> getByVehicle(Long vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle getVehicleByPlate(String plate) {
		// TODO Auto-generated method stub
		return null;
	}

}

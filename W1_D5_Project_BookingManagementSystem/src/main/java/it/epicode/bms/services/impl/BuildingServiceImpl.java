package it.epicode.bms.services.impl;

import org.springframework.stereotype.Service;

import it.epicode.bms.entities.Building;
import it.epicode.bms.repositories.BuildingRepository;
import it.epicode.bms.services.BuildingService;

@Service
public class BuildingServiceImpl extends CrudServiceImpl<Building> implements BuildingService {

	protected BuildingServiceImpl(BuildingRepository repo) {
		super(repo);
	}

}

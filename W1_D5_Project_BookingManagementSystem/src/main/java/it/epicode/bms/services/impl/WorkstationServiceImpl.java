package it.epicode.bms.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.epicode.bms.entities.Workstation;
import it.epicode.bms.repositories.WorkstationRepository;
import it.epicode.bms.services.WorkstationService;

@Service
public class WorkstationServiceImpl extends CrudServiceImpl<Workstation> implements WorkstationService {

	protected WorkstationServiceImpl(WorkstationRepository repo) {
		super(repo);
	}

	@Override
	public List<Workstation> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Workstation> getByCode(String code) {
		return ((WorkstationRepository)repo).findOneByCode(code);
	}

}

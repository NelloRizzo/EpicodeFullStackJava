package it.epicode.devicesmanagement.businesslayer.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.devicesmanagement.businesslayer.dto.EmployeeDto;
import it.epicode.devicesmanagement.businesslayer.services.EmployeeService;
import it.epicode.devicesmanagement.businesslayer.services.ImageStorageService;
import it.epicode.devicesmanagement.datalayer.entities.EmployeeEntity;
import it.epicode.devicesmanagement.datalayer.repositories.EmployeesRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeDto, EmployeeEntity> implements EmployeeService {

	@Autowired
	ImageStorageService imageStorage;

	public EmployeeServiceImpl(EmployeesRepository repository) {
		super(repository);
	}

	@Override
	public EmployeeDto save(EmployeeDto dto) {
		try {
			if (dto.getFile() != null) {
				var fn = new StringBuilder(dto.getFile().getOriginalFilename());
				dto.setImagePicture(imageStorage.store(dto.getFile().getBytes(), fn.substring(0,fn.lastIndexOf(".")).toString()));
			}

			return super.save(dto);
		} catch (IOException e) {
			log.error("Exception uploading picture", e);
			throw new RuntimeException(e);
		}
	}
}

package it.epicode.devicesmanagement.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.devicesmanagement.datalayer.entities.EmployeeEntity;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long>{

}

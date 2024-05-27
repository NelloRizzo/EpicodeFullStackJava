package it.epicode.devicesmanagement.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.devicesmanagement.datalayer.entities.DeviceEntity;

public interface DevicesRepository extends JpaRepository<DeviceEntity, Long> {

}

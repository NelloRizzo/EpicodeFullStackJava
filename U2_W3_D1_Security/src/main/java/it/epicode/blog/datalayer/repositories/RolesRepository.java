package it.epicode.blog.datalayer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.datalayer.entities.RoleEntity;

public interface RolesRepository extends JpaRepository<RoleEntity, Long>{
	
	Optional<RoleEntity> findOneByName(String roleName);

}

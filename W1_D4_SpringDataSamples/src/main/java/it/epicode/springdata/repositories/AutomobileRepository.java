package it.epicode.springdata.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.springdata.data.Automobile;

public interface AutomobileRepository extends JpaRepository<Automobile, Integer>{

	List<Automobile> findByAnnoProduzione(int annoProduzione);
	List<Automobile> findByMarcaOrAnnoProduzioneGreaterThanOrderByTargaDesc(String marca, int anno);
	
	@Query("SELECT a FROM Automobile a WHERE a.marca = :marca AND a.annoProduzione > :anno ORDER BY a.targa DESC")
	List<Automobile> findByMarcaAndAnnoProduzione(String marca, int anno);
}

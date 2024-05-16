package it.epicode.springdata.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import it.epicode.springdata.data.Automobile;
import it.epicode.springdata.repositories.AutomobileRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Primary
@Slf4j
public class JpaAutomobileDao implements AutomobileDao {

	@Autowired
	AutomobileRepository repo;
	
	@Override
	public void insert(Automobile auto) {
		log.info("JpaAutomobileDao.insert()");
		repo.save(auto);
	}

	@Override
	public void update(Automobile auto) {
		log.info("JpaAutomobileDao.update()");
		repo.save(auto);
	}

	@Override
	public void delete(Integer id) {
		log.info("JpaAutomobileDao.insert()");
		repo.deleteById(id);
	}

	@Override
	public Automobile getById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Automobile> getByAnnoProduzione(int annoProduzione) {
		return repo.findByAnnoProduzione(annoProduzione);
	}

}

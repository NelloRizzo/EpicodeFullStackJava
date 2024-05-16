package it.epicode.springdata.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.springdata.dao.AutomobileDao;
import it.epicode.springdata.data.Automobile;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JdbcRunner implements CommandLineRunner {

	@Autowired
	AutomobileDao dao;

	@Override
	public void run(String... args) throws Exception {
		var auto1 = Automobile.builder() //
				.withAnnoProduzione(2023) //
				.withColore("Rosso") //
				.withId(1) //
				.withMarca("Ferrari") //
				.withTarga("FE001FE") //
				.build();
		var auto2 = Automobile.builder() //
				.withAnnoProduzione(2023) //
				.withColore("Verde") //
				.withId(2) //
				.withMarca("Lamborghini") //
				.withTarga("LA001LA") //
				.build();
		var auto3 = Automobile.builder() //
				.withAnnoProduzione(2022) //
				.withColore("Bianco") //
				.withId(3) //
				.withMarca("Fiat") //
				.withTarga("FI001FI") //
				.build();
		dao.delete(1);
		dao.delete(2);
		dao.delete(3);
		dao.insert(auto1);
		dao.insert(auto2);
		dao.insert(auto3);

		var autos = dao.getByAnnoProduzione(2023);
		autos.forEach(a -> log.info("ByAnnoProduzione: {}", a));

		log.info("ById: {}", dao.getById(3));
	}
}

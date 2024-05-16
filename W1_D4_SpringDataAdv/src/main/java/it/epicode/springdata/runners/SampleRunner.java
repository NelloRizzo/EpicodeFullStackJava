package it.epicode.springdata.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.springdata.data.ToDo;
import it.epicode.springdata.data.User;
import it.epicode.springdata.repositories.ToDoRepository;
import it.epicode.springdata.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleRunner implements CommandLineRunner {

	@Autowired
	UsersRepository users;
	@Autowired
	ToDoRepository todo;

	@Override
	public void run(String... args) throws Exception {
		var user = users.save(User.builder().withUsername("Nello").build());
		todo.save(ToDo.builder().withDateTime(LocalDateTime.now()).withDescription("Primo Appuntamento").withUser(user)
				.build());
		todo.save(ToDo.builder().withDateTime(LocalDateTime.now().plusDays(-3)).withDescription("Primo Appuntamento")
				.withDone(true).withUser(user).build());
		todo.save(ToDo.builder().withDateTime(LocalDateTime.now().plusDays(5)).withDescription("Primo Appuntamento")
				.withUser(user).build());

		log.info("To-Do collegati agli utenti");
		users.findAll().forEach(u -> log.info("{}", u.getTodoes()));

		log.info("Tutti i to-do");
		todo.findAll().forEach(t -> log.info("{}", t));
		log.info("Tutti i to-do da completare");
		todo.findByDone(false).forEach(t -> log.info("{}", t));
		log.info("Tutti i to-do completati");
		todo.findByDone(true).forEach(t -> log.info("{}", t));

		log.info("Tutti i to-do tra ieri e oggi");
		todo.findByDateTimeBetween(LocalDateTime.now().plusDays(-1), LocalDateTime.now().plusHours(1)) //
				.forEach(t -> log.info("{}", t));
		;
		log.info("Tutti i to-do di 'nello'");
		todo.findByUserUsernameIgnoreCase("nello") //
				.forEach(t -> log.info("{}", t));
		;
	}

}

package it.epicode.w2d4.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.w2d4.data.User;
import it.epicode.w2d4.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PopulateUsersRunner implements CommandLineRunner {
	@Autowired
	UsersRepository users;

	@Override
	public void run(String... args) throws Exception {
		log.info("Populating users...");
		users.saveAll(List.of( //
				User.builder().withEmail("nellorizzo@live.it").withUsername("Nello1").withPassword("password").build(),
				User.builder().withEmail("nello.rizzo@libero.it").withUsername("Nello2").withPassword("password")
						.build()));
		log.info("Users populated");
	}

}

package it.epicode.bms;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import it.epicode.bms.entities.Building;
import it.epicode.bms.entities.User;
import it.epicode.bms.entities.Workstation;
import it.epicode.bms.repositories.BuildingRepository;
import it.epicode.bms.repositories.UserRepository;
import it.epicode.bms.repositories.WorkstationRepository;

@SpringBootTest
class RepositoriesTests {

	@Autowired
	UserRepository users;

	@Autowired
	WorkstationRepository workstations;

	@Autowired
	BuildingRepository buildings;

	@AfterEach
	void purge() {
		users.deleteAll();
		workstations.deleteAll();
		buildings.deleteAll();
	}

	@Test
	void saveUsers() {
		// inserimento di valori senza errori
		assertDoesNotThrow(() -> {
			users.save(User.builder().withEmail("nellorizzo@live.it").withFullName("Nello Rizzo").withUsername("nello")
					.build());
			users.save(User.builder().withEmail("nello.rizzo@libero.it").withFullName("Nello Rizzo")
					.withUsername("^nello^").build());
			users.save(User.builder().withEmail("nellorizzo@tiscali.it").withFullName("Nello Rizzo")
					.withUsername("_nello_").build());
		});
		// tentativo di inserire una email duplicata
		assertThrows(DataIntegrityViolationException.class, () -> users.save(User.builder()
				.withEmail("nellorizzo@live.it").withFullName("Nello Rizzo").withUsername("nello").build()));
	}

	@Test
	void saveWorkstations() {
		// inserimento di valori senza errori
		assertDoesNotThrow(() -> {
			workstations.save(Workstation.builder()
					.withBuilding(Building.builder().withAddress("viale Monza, 14").withCity("Milano")
							.withName("Milano Meeting Center").build())
					.withCode("0001").withDescription("Postazione n. 1 - Milano").withMaxAttendance(5)
					.withType(Workstation.Type.OPENSPACE).build());
			workstations.save(Workstation.builder()
					.withBuilding(Building.builder().withAddress("via Cristoforo Colombo, 124").withCity("Roma")
							.withName("Edificio di Roma").build())
					.withCode("0002").withDescription("Postazione n. 2 - Roma").withMaxAttendance(15)
					.withType(Workstation.Type.MEETING_ROOM).build());
			workstations.save(Workstation.builder()
					.withBuilding(Building.builder().withAddress("corso Garibaldi, 34").withCity("Napoli")
							.withName("Palazzo sito a Napoli").build())
					.withCode("0001").withDescription("Postazione n. 3 - Napoli").withMaxAttendance(2)
					.withType(Workstation.Type.PRIVATE).build());
		});
	}
}

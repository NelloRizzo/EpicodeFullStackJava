package it.epicode.bms;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.bms.entities.Building;
import it.epicode.bms.entities.User;
import it.epicode.bms.entities.Workstation;
import it.epicode.bms.entities.Workstation.Type;
import it.epicode.bms.services.BookingService;
import it.epicode.bms.services.BuildingService;
import it.epicode.bms.services.UserService;
import it.epicode.bms.services.WorkstationService;
import it.epicode.bms.services.dto.AddBookingDto;

@SpringBootTest
public class ServicesTests {

	@Autowired
	BookingService bookings;

	@Autowired
	UserService users;

	@Autowired
	WorkstationService workstations;
	
	@Autowired
	BuildingService buildings;

	@AfterEach
	void purge() {
		bookings.deleteAll();
		users.deleteAll();
		workstations.deleteAll();
		buildings.deleteAll();
	}

	@Test
	void addBooking() {
		var user = users.getByEmail("for_test_only@domain.com").orElse(users.save(User.builder()
				.withEmail("for_test_only@domain.com").withFullName("Test User").withUsername("nello").build()));
		var workstation = workstations.getByCode("TEST")
				.orElse(workstations.save(Workstation.builder()
						.withBuilding(Building.builder().withAddress("for test purpose only").withCity("Test")
								.withName("Test Workstation").build())
						.withCode("TEST").withDescription("Test").withMaxAttendance(1).withType(Type.MEETING_ROOM)
						.build()));
		bookings.addBooking(AddBookingDto.builder().withDate(LocalDate.now()).withEmail(user.getEmail())
				.withWorkstationId(workstation.getId()).build()).orElseThrow();
		assertThat(bookings.getAll().size() > 0);
	}

}

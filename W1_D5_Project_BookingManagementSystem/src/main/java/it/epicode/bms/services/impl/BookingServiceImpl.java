package it.epicode.bms.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.bms.entities.Booking;
import it.epicode.bms.repositories.BookingRepository;
import it.epicode.bms.repositories.UserRepository;
import it.epicode.bms.repositories.WorkstationRepository;
import it.epicode.bms.services.BookingService;
import it.epicode.bms.services.dto.AddBookingDto;

@Service
public class BookingServiceImpl extends CrudServiceImpl<Booking> implements BookingService {

	@Autowired
	UserRepository users;
	@Autowired
	WorkstationRepository workstations;

	protected BookingServiceImpl(BookingRepository repo) {
		super(repo);
	}

	@Override
	public Optional<Booking> addBooking(AddBookingDto dto) {
		var user = users.findFirstByEmail(dto.getEmail()).orElseThrow();
		var workstation = workstations.findById(dto.getWorkstationId()).orElseThrow();
		var booking = repo.save( //
				Booking.builder().withDate(dto.getDate()).withUser(user).withWorkstation(workstation).build());
		return Optional.of(booking);
	}

	@Override
	public List<Booking> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Booking> getAllByUser(String userEmail) {
		return ((BookingRepository) repo).findAllByUserEmail(userEmail);
	}

}

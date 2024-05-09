package it.epicode.bw1.transportcompany.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.tickets.Subscription;
import it.epicode.bw1.transportcompany.entities.tickets.TravelDocument;
import it.epicode.bw1.transportcompany.entities.users.User;

public interface TravelDocumentDao extends Dao<TravelDocument> {

	Optional<Subscription> getFirstSubscription();

	Optional<Subscription> addSubscription(User user, Subscription subscription);

	List<TravelDocument> getDocumentsByPeriod(LocalDateTime from, LocalDateTime to);

	List<TravelDocument> getDocumentsByPeriodAndReseller(LocalDateTime from, LocalDateTime to, Reseller r);
}

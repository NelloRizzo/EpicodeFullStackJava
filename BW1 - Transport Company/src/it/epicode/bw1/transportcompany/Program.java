package it.epicode.bw1.transportcompany;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.bw1.transportcompany.dao.factories.DaoFactory;
import it.epicode.bw1.transportcompany.dao.factories.DaoFactoryImpl;
import it.epicode.bw1.transportcompany.entities.fleet.Bus;
import it.epicode.bw1.transportcompany.entities.fleet.Tram;
import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.resellers.VendingMachine;
import it.epicode.bw1.transportcompany.entities.resellers.Vendor;
import it.epicode.bw1.transportcompany.entities.tickets.Subscription;
import it.epicode.bw1.transportcompany.entities.tickets.Ticket;
import it.epicode.bw1.transportcompany.entities.tickets.TimeSpan;
import it.epicode.bw1.transportcompany.entities.tickets.TimeSpanUnit;
import it.epicode.bw1.transportcompany.entities.tickets.TravelDocument;
import it.epicode.bw1.transportcompany.entities.users.Card;
import it.epicode.bw1.transportcompany.entities.users.User;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static final Random rnd = new Random(1234);
	private static DaoFactory factory = new DaoFactoryImpl();

	private static String randomCode(String model) {
		return model.chars() //
				.map(c -> c + rnd.nextInt(Character.isAlphabetic(c) ? 26 : 10)) //
				.mapToObj(c -> Character.toString(c)) //
				.collect(Collectors.joining());
	}

	private static Card randomCard() {
		return new Card(randomCode("AAA000"), LocalDateTime.now().plusMonths(-rnd.nextInt(36)));
	}

	private static List<User> getTestUsers(int count) {
		return LongStream.range(1, count + 1).mapToObj(n -> new User(String.format("User %d", n), randomCard()))
				.toList();
	}

	private static List<Reseller> getTestResellers(int count) {
		return LongStream.range(1, count + 1).mapToObj(n -> (Reseller) (rnd.nextBoolean() ? //
				new Vendor(String.format("Vendor %d", n)) : //
				new VendingMachine(String.format("Vending Machine %d", n), rnd.nextBoolean())))//
				.toList();
	}

	private static List<TravelDocument> getTestDocuments(int count) {
		var resellers = getTestResellers(count);
		return LongStream.range(1, count + 1).mapToObj(n -> rnd.nextBoolean() ? //
				new Ticket(randomCode("AAAAAAAAA"), resellers.get(rnd.nextInt(resellers.size())), LocalDateTime.now()) : //
				new Subscription(randomCode("AAAA0000000000"), resellers.get(rnd.nextInt(count)),
						LocalDateTime.now().plusMonths(-rnd.nextInt(36)), //
						new TimeSpan(rnd.nextInt(count), TimeSpanUnit.DAYS))) //
				.toList();
	}

	public static void testUsers(int count) {
		var dao = factory.getUserDao();
		log.debug("Creating {} users", count);
		dao.save(getTestUsers(10));
	}

	public static void testDocuments(int count) {
		var dao = factory.getTravelDocumentDao();
		log.debug("Creating {} documents", count);
		dao.save(getTestDocuments(count));
	}

	private static void testUsersSubscriptions() {
		var userId = 1;
		var users = factory.getUserDao();
		var docs = factory.getTravelDocumentDao();
		docs.getFirstSubscription().ifPresentOrElse( //
				doc -> users.find(userId).ifPresentOrElse( //
						user -> {
							docs.addSubscription(user, doc);
							log.debug("Subscription added: {}", user);
						}, //
						() -> log.debug("User with id {} not found", userId)), //
				() -> log.error("Cannot find any subscriptions"));
	}

	private static void testRenewCard() {
		var userId = 1;
		var dao = factory.getUserDao();
		dao.find(userId) //
				.ifPresentOrElse( //
						user -> {
							log.debug("Before renew, card expires at {}", user.getCard().getExpiration());
							dao.renewCard(user, LocalDateTime.now());
							log.debug("After renew, card expires at {}", user.getCard().getExpiration());
						}, //
						() -> log.error("User not found"));

	}

	public static void testRetrieveDocuments(LocalDateTime from, LocalDateTime to, int resellerId) {
		var users = factory.getTravelDocumentDao();
		log.debug("Documents from {} to {}", from, to);
		users.getDocumentsByPeriod(from, to).forEach(i -> log.debug("{}", i));

		var resellers = factory.getResellerDao();
		resellers.find(resellerId).ifPresentOrElse( //
				r -> {
					log.debug("Documents from {} to {} issued by reseller {}", from, to, r);
					users.getDocumentsByPeriodAndReseller(from, to, r).forEach(i -> log.debug("{}", i));
				}, //
				() -> log.error("Cannot find reseller with id = {}", resellerId));
	}

	public static void testFleet() {
		var fleets = factory.getFleetDao();
		var bus = new Bus("81/");
		var tram = new Tram("1N");
		fleets.save(bus);
		fleets.save(tram);
		fleets.findAll().stream().forEach(v -> log.debug("{}", v));
		fleets.setInMantenance(bus);
		fleets.getInMantenance().stream().forEach(m -> log.debug("Maintenance: {}", m));
		fleets.setInService(bus);
		fleets.find(bus.getId()).ifPresentOrElse(v -> log.debug("{}", v), () -> log.error("Vehicle not found"));
		fleets.setInMantenance(tram);
	}

	public static void main(String[] args) {
		testUsers(10);
		testDocuments(10);
		testUsersSubscriptions();
		testRenewCard();
		testRetrieveDocuments(LocalDateTime.now().minusYears(3), LocalDateTime.now(), 1);
		testFleet();
	}

}

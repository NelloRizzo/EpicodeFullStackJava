package it.epicode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {

	static final Logger logger = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		logger.warn("Ciao a tutti!");
		logger.debug("Ciao a tutti");
		logger.info("Ciao a tutti");
		logger.trace("Ciao a tutti");

		var list = IntStream.range(0, 1000) //
				.filter(n -> n % 2 == 0) //
				// .mapToObj(n -> n) //
				.boxed().collect(Collectors.toList());

		logger.error("Dimensione della lista: {}", list.size());

		var datas = Arrays.asList( //
				new Data(1, "Uno"), //
				new Data(2, "Due"), //
				new Data(3, "Tre"), //
				new Data(0, "Zero") //
		);
		datas.stream() //
				.sorted(Comparator.comparing(Data::getName).reversed()) //
				.limit(3) //
				.forEach(System.out::println);

		Optional<String> d = datas.stream() //
				.filter(dx -> dx.getValue() == 1) //
				.map(Data::getName) //
				.findFirst();
		if (d.isEmpty())
			logger.debug("Il dato non esiste");
		else
			logger.debug("Il dato è {}", d.get());

		d.ifPresentOrElse( //
				x -> logger.debug("Il dato è {}", x), //
				() -> logger.debug("Il dato non esiste"));

		datas.stream() //
				.filter(dx -> dx.getValue() == 1000) //
				.map(Data::getName) //
				.findFirst() //
				.ifPresentOrElse( //
						x -> logger.debug("Il dato è {}", x), //
						() -> logger.debug("Il dato non esiste"));

	}

}

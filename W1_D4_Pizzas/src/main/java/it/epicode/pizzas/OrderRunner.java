package it.epicode.pizzas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderRunner implements CommandLineRunner {

	@Value("${order.seatAmount}")
	double seatAmount;

	@Override
	public void run(String... args) throws Exception {
	}

}

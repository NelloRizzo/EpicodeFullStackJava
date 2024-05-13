package it.epicode.pizza;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.pizza.config.BeansConfiguration;
import it.epicode.pizza.entities.Menu;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class W1D1PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(W1D1PizzeriaApplication.class, args);

		// try-with-resources (*)
		try (var ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class)) {
			var menu = (Menu) ctx.getBean("menu");

			log.info("Menu Standard:");
			menu.printMenu(false);
			log.info("Menu XL:");
			menu.printMenu(true);
			// (*) qui chiude automaticamente il context richiamando ctx.close()
		} catch (BeansException e) {
			log.error("Exception in main()", e);
		}

	}

}

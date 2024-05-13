package it.epicode.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

	@Bean(name = "myCounter")
	Counter getCounter() {
		System.out.println("Sto eseguendo getCounter()");
		return new Counter();
	}
	
	@Bean(name="myOtherCounter")
	Counter getOtherCounter() {
		System.out.println("Sto eseguento l'inizializzazione tramite getOtherCounter()");
		var c = new Counter();
		c.setValue(100);
		return c;
	}
}

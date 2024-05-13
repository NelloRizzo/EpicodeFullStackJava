package it.epicode.demo;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
		
		var myCounter = new Counter();
		var mySecondCounter = new Counter();
		myCounter.increment();
		mySecondCounter.increment();
		System.out.println(myCounter);
		System.out.println(mySecondCounter);
		
		try (var ctx = new AnnotationConfigApplicationContext(MyAppConfig.class)) {
			var c1 = (Counter)ctx.getBean("myCounter");
			var c2 = (Counter)ctx.getBean("myCounter");
			c1.increment();
			c2.increment();
			System.out.println(c1);
			System.out.println(c2);
			c2.increment();
			System.out.println(c1);
			log.info("Ciao a tutti dal logger");
			var c3 = (Counter)ctx.getBean("myOtherCounter");
			log.info("Counter: {}", c3);
			System.out.println();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}

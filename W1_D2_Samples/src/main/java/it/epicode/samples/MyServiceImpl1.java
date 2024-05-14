package it.epicode.samples;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("first-service")
@Slf4j
public class MyServiceImpl1 implements MyService {

	@Override
	public void printLog() {
		log.info("Info da MyService1");
	}

}

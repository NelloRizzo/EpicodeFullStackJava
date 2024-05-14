package it.epicode.samples;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("second-service")
@Slf4j
@Primary
public class MyServiceImpl2 implements MyService {

	@Override
	public void printLog() {
		log.info("Info da MyService2");
	}

}

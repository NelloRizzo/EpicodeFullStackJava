package it.epicode.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Parameters {

	@Value("${spring.application.name}")
	String name;

	@Value("${myname}")
	String myName;
	
	@Value("${numero}")
	Integer number;
}

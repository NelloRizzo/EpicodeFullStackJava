package it.epicode.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ConstructorAutowired {

	private final Parameters parameters;
	
	@Autowired
	public ConstructorAutowired(Parameters p) {
		this.parameters = p;
	}
}

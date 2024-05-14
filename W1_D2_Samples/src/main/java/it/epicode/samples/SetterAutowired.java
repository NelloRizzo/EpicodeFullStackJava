package it.epicode.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class SetterAutowired {

	@Getter
	private Parameters parameters;
	
	@Autowired
	public void setParameters(Parameters p) {
		this.parameters = p;
	}
}

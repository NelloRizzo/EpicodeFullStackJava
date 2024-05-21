package it.epicode.web.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Person {
	private String firstName;
	private String lastName;
}

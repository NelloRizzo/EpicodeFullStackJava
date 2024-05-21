package it.epicode.restapi.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Salutation {
	private String name;
	private String greetings;
	@Builder.Default
	private String language = "it";
}

package it.epicode.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.epicode.restapi.data.Salutation;

@Service
public class AppServiceImpl implements AppService {
	private static final String IT = "Ciao, %s";
	private static final String EN = "Hello, %s";

	@Override
	public List<Salutation> getSalutationForUsername(String username) {
		return List.of( //
				Salutation.builder().withGreetings(String.format(IT, username)).withLanguage("it").withName(username)
						.build(),
				Salutation.builder().withGreetings(String.format(EN, username)).withLanguage("en").withName(username)
						.build());
	}

}

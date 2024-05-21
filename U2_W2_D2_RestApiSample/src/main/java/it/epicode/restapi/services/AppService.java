package it.epicode.restapi.services;

import java.util.List;

import it.epicode.restapi.data.Salutation;

public interface AppService {
	List<Salutation> getSalutationForUsername(String username);
}

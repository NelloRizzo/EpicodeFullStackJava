package it.epicode.w2d4.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.w2d4.data.Message;
import it.epicode.w2d4.services.dto.MessageDto;

public interface MessageService {
	// invio di un messaggio
	void send(MessageDto message);
	// lettura di un messaggio attraverso l'id
	MessageDto read(Long id);
	// recupero di tutti i messaggi destinati ad un utente
	Page<Message> readReceived(String recipient, Pageable pageable);
	// recupero di tutti i messaggi inviati da un utente
	Page<Message> readSent(String recipient, Pageable pageable);
}

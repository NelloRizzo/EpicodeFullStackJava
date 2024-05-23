package it.epicode.w2d4.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import it.epicode.w2d4.controllers.exceptions.ApiValidationException;
import it.epicode.w2d4.controllers.exceptions.UserNotFoundException;
import it.epicode.w2d4.data.Message;
import it.epicode.w2d4.repositories.MessagesRepository;
import it.epicode.w2d4.repositories.UsersRepository;
import it.epicode.w2d4.services.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

	@Autowired
	UsersRepository users;

	@Autowired
	MessagesRepository messages;

	@Override
	public void send(MessageDto message) {
		try {
			// recupera il mittente
			var sender = users.findOneByEmail(message.getSender()).orElseThrow(() -> new UserNotFoundException(
					List.of(new FieldError("message", "sender", "Il mittente non esiste nel database"))));
			// recupera il destinatario
			var recipient = users.findOneByEmail(message.getRecipient()).orElseThrow(() -> new UserNotFoundException(
					List.of(new FieldError("message", "recipient", "Il destinatario non esiste nel database"))));
			// costruisce il messaggio
			var msg = Message.builder() //
					.withBody(message.getBody()).withFrom(sender).withRead(false) //
					.withSentAt(LocalDateTime.now()).withTitle(message.getTitle()).withTo(recipient).build();
			// lo salva sul database
			messages.save(msg);
		} catch (ApiValidationException e) {
			log.error("Errore di validazione", e);
			throw e;
		} catch (Exception e) {
			log.error("Eccezione non prevista", e);
			throw e;
		}
	}

	@Override
	public MessageDto read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Message> readReceived(String recipient, Pageable pageable) {
		try {
			var received = messages.findAllByToEmail(recipient, pageable);
			return received;
		} catch (Exception e) {
			log.error("Exception reading received messages", e);
			throw e;
		}
	}

	@Override
	public Page<Message> readSent(String recipient, Pageable pageable) {
		try {
			var sent = messages.findAllByFromEmail(recipient, pageable);
			return sent;
		} catch (Exception e) {
			log.error("Exception reading sent messages", e);
			throw e;
		}
	}

}

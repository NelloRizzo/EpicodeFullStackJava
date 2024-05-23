package it.epicode.w2d4.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.w2d4.controllers.exceptions.BadRequestException;
import it.epicode.w2d4.controllers.models.MessageRequest;
import it.epicode.w2d4.data.Message;
import it.epicode.w2d4.services.MessageService;
import it.epicode.w2d4.services.dto.MessageDto;
import kong.unirest.Unirest;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {

	@Autowired
	MessageService messages;

	private static final String URI_UNIREST = "https://api.mailgun.net/v3/sandboxc985b9cf81fd46cebd6229bba0f14527.mailgun.org";
	private static final String APIKEY_UNIREST = "";
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody @Validated MessageRequest message, BindingResult validator) {
		if (validator.hasErrors()) {
			throw new BadRequestException(validator.getAllErrors());
		}
		messages.send(MessageDto.builder().withBody(message.body()).withRecipient(message.recipient())
				.withSender(message.sender()).withTitle(message.title()).build());
		
		var response = Unirest.post(URI_UNIREST + "/messages")
				.basicAuth("api", APIKEY_UNIREST)
				.queryString("from", message.sender())
				.queryString("to", message.recipient())
				.queryString("subject", message.title())
				.queryString("text", message.body())
				.asJson();
		return ResponseEntity.ok(response.getStatusText());
	}

	@GetMapping("received/{email}")
	public ResponseEntity<Page<Message>> readReceivedMessages(@PathVariable String email) {
		return new ResponseEntity<Page<Message>>(messages.readReceived(email, Pageable.unpaged()), HttpStatus.OK);
	}
	@GetMapping("sent/{email}")
	public ResponseEntity<Page<Message>> readSentMessages(@PathVariable String email) {
		return new ResponseEntity<Page<Message>>(messages.readSent(email, Pageable.unpaged()), HttpStatus.OK);
	}
}

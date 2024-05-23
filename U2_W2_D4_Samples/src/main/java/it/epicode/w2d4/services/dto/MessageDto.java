package it.epicode.w2d4.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class MessageDto {
	private long id;

	private String recipient;
	private String sender;
	private String title;
	private String body;
}

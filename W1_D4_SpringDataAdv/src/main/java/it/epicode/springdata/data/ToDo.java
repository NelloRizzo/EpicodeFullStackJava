package it.epicode.springdata.data;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class ToDo {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime dateTime;
	@Column(length = 255)
	private String description;
	private boolean done;
	@ManyToOne
	private User user;
}

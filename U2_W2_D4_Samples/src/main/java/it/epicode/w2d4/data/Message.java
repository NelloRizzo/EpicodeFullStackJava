package it.epicode.w2d4.data;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Message {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private User from;
	@ManyToOne
	private User to;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime sentAt;
	private boolean read;
	@Column(length = 80, nullable = false)
	private String title;
	@Column(length = 1024, nullable = false)
	private String body;
	@ManyToOne(optional = true)
	private Message parent;
}

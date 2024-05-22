package it.epicode.w2d3.fines.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fines")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Fine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fine_seq")
	@SequenceGenerator(name = "fine_seq", sequenceName = "fine_seq")
	@EqualsAndHashCode.Include
	public Long id;
	@Builder.Default
	LocalDateTime emittedAt = LocalDateTime.now();

	@ManyToOne
	private Vehicle vehicle;
	@Column(length = 255, nullable = false)
	private String reason;
	@Column(length = 80, nullable = false)
	private String agentName;
}

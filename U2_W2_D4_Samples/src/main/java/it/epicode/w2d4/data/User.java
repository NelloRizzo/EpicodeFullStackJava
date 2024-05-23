package it.epicode.w2d4.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", indexes = { @Index(name = "idx_email_unique", columnList = "email", unique = true) })
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 25, nullable = false)
	private String username;
	@Column(length = 100, nullable = false)
	private String email;
	@Column(length = 15, nullable = false)
	private String password;
}

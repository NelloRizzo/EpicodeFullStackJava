package it.epicode.bms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Table(name = "users", indexes = { @Index(columnList = "email", unique = true, name = "idx_unique_email") })
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class User extends BaseEntity {
	@Column(length = 12, nullable = false)
	private String username;
	@Column(length = 25, nullable = false)
	private String fullName;
	@Column(length = 125, nullable = false)
	private String email;

	@OneToMany(mappedBy = "user")
	private final List<Booking> bookings = new ArrayList<>();
}

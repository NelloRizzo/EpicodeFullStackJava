package it.epicode.blog.datalayer.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq")
	private long id;
	@Column(length = 125, unique = true, nullable = false)
	@EqualsAndHashCode.Include
	private String username;
	@Column(length = 125, nullable = false)
	private String password;
	@Column(length = 25)
	private String friendlyName;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private final List<RoleEntity> roles = new ArrayList<>();
}

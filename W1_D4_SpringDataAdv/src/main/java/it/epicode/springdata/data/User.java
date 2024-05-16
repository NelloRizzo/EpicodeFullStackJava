package it.epicode.springdata.data;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 20)
	private String username;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	private List<ToDo> todoes = new ArrayList<>();
}

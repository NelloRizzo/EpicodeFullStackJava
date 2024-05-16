package it.epicode.springdata.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "automobili")
@Builder(setterPrefix = "with")
public class Automobile {
	@Id
	private Integer id;
	private String targa;
	@Column(name = "annoproduzione")
	private int annoProduzione;
	private String colore;
	private String marca;
}

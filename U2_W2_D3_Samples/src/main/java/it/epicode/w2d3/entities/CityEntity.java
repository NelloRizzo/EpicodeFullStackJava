package it.epicode.w2d3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "cities", //
		indexes = { @Index(name = "idx_unique_city", columnList = "province_id,name", unique = true), //
				@Index(name = "idx_unique_code", columnList = "cadastral", unique = true) })
public class CityEntity extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 4, nullable = false)
	@EqualsAndHashCode.Include
	private String cadastral;
	private boolean capital;
	@ManyToOne
	@JoinColumn(name = "province_id")
	private ProvinceEntity province;
}

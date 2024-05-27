package it.epicode.blog.datalayer.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class ArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_seq")
	@SequenceGenerator(name = "articles_seq", sequenceName = "articles_seq")
	private long id;
	@Column(length = 80, nullable = false)
	private String title;
	@Column(length = 1024, nullable = false)
	private String content;
	@ManyToOne
	private UserEntity author;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime publicationDate;
	@Column(length = 255, nullable = true)
	private String coverImage;
}

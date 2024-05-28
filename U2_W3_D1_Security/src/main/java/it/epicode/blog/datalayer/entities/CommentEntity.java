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
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "comments")
public class CommentEntity extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
	@SequenceGenerator(name = "comments_seq", sequenceName = "comments_seq")
	@EqualsAndHashCode.Include
	private long id;
	@Column(length = 1024, nullable = false)
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime publishedAt;
	@ManyToOne
	private UserEntity author;
	@ManyToOne
	private ArticleEntity article;
}

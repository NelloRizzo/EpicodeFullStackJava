package it.epicode.blog.services;

import java.util.List;
import java.util.Optional;

import it.epicode.blog.entities.Author;

public interface AuthorService {

	List<Author> getAuthors();

	Optional<Author> getAuthor(Long id);

	Author save(Author author);

	Author update(Long authorId, Author author);

	Author delete(Long authorId);
}

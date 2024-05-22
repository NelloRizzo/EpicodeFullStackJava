package it.epicode.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.blog.entities.Author;
import it.epicode.blog.repositories.AuthorsRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorsRepository authors;

	@Override
	public List<Author> getAuthors() {
		return authors.findAll();
	}

	@Override
	public Optional<Author> getAuthor(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Author save(Author author) {
		var a = authors.save(author);
		return a;
	}

	@Override
	public Author update(Long authorId, Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author delete(Long authorId) {
		// TODO Auto-generated method stub
		return null;
	}

}

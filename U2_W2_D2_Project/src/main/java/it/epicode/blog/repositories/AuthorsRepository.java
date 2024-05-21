package it.epicode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.entities.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

}

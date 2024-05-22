package it.epicode.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.entities.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

	Optional<Category> findFirstByName(String name);
}

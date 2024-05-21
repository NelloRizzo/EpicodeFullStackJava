package it.epicode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.entities.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long>{

}

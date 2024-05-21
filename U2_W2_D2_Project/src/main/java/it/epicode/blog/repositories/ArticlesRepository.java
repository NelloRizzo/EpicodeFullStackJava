package it.epicode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.entities.Article;

public interface ArticlesRepository extends JpaRepository<Article, Long>{

}

package it.epicode.blog.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.datalayer.entities.ArticleEntity;

public interface ArticlesRepository extends JpaRepository<ArticleEntity, Long> {

}

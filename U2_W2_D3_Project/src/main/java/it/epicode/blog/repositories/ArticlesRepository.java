package it.epicode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.blog.entities.Article;

public interface ArticlesRepository extends JpaRepository<Article, Long>, PagingAndSortingRepository<Article, Long>{

}

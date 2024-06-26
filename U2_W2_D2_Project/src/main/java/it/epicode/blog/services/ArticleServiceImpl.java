package it.epicode.blog.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.blog.entities.Article;
import it.epicode.blog.repositories.ArticlesRepository;
import it.epicode.blog.utils.EntitiesUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticlesRepository articles;
	
	@Autowired
	EntitiesUtils utils;

	@Override
	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Article> getArticle(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Article save(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article update(Long articleId, Article article) {
		try {
			var a = articles.findById(articleId).orElseThrow();
			utils.copy(article, a);
			return article;
		} catch (NoSuchElementException e) {
			log.error(String.format("Cannot find article with id = %s", articleId), e);
			throw new RuntimeException("Cannot find article...");
		} catch (Exception e) {
			log.error(String.format("Error deleting article with id = %s", articleId), e);
			throw new RuntimeException();
		}	}

	@Override
	public Article delete(Long articleId) {
		try {
			var article = articles.findById(articleId).orElseThrow();
			articles.delete(article);
			return article;
		} catch (NoSuchElementException e) {
			log.error(String.format("Cannot find article with id = %s", articleId), e);
			throw new RuntimeException("Cannot find article...");
		} catch (Exception e) {
			log.error(String.format("Error deleting article with id = %s", articleId), e);
			throw new RuntimeException();
		}
	}

}

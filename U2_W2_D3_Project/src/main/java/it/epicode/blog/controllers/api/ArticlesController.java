package it.epicode.blog.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.blog.entities.Article;
import it.epicode.blog.services.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

	@Autowired
	ArticleService articles;

	// GET /blogPosts
	@GetMapping
	public ResponseEntity<Page<Article>> getArticles(Pageable p) {
		return new ResponseEntity<Page<Article>>(articles.getArticles(p), HttpStatus.OK);
	}

	// GET /blogPosts/123 -> id = 123
	@GetMapping("{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Long id) {
		return null;
	}

	// POST /blogPosts
	@PostMapping
	public ResponseEntity<Article> save(@RequestBody Article article) {
		return null;
	}

	// PUT /blogPosts/123 -> id = 123
	@PutMapping("{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
		return null;
	}

	// DELETE /blogPosts/123 -> id = 123
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Article delete(@PathVariable Long id) {
		return articles.delete(id);
	}

}

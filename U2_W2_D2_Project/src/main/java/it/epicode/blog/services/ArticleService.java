package it.epicode.blog.services;

import java.util.List;
import java.util.Optional;

import it.epicode.blog.entities.Article;

public interface ArticleService {

	/**
	 * @return l'elenco di tutti gli articoli.
	 */
	// richiamato dal controller che risponde a GET /blogPosts
	List<Article> getArticles();

	/**
	 * Recupera un articolo tramite l'id.
	 * @param id l'id dell'articolo.
	 * @return l'articolo corrispondente.
	 */
	// richiamato dal controller che risponde a GET /blogPosts/123
	Optional<Article> getArticle(Long id);

	/**
	 * Crea un nuovo articolo.
	 * @param article l'articolo da salvare.
	 * @return l'articolo dopo il salvataggio.
	 */
	// richiamato dal controller che risponde a POST /blogPosts
	Article save(Article article);

	/**
	 * Modifica un articolo.
	 * @param articleId la chiave dell'articolo da modificare.
	 * @param article i dati con i quali modificare l'articolo.
	 * @return l'articolo dopo il salvataggio.
	 */
	// richiamato dal controller che risponde a PUT /blogPosts/123
	Article update(Long articleId, Article article);

	/**
	 * Elimina un articolo.
	 * @param articleId la chiave dell'articolo da eliminare
	 * @return l'articolo presente sul database prima di essere eliminato.
	 */
	// richiamato dal controller che risponde a DELETE /blogPost/123
	Article delete(Long articleId);
}

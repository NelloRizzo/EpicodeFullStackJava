package it.epicode.services;

import java.util.List;
import java.util.Optional;

import it.epicde.data.Book;
import it.epicde.data.Item;

/**
 * Servizio di gestione della libreria.
 * 
 * @author Nello
 *
 */
public interface LibraryService extends AutoCloseable {
	/**
	 * Aggiunge un elemento in libreria.
	 * 
	 * @param item l'elemento da aggiungere.
	 */
	void add(Item item);

	/**
	 * Rimuove un elemento dalla libreria.
	 * 
	 * @param isbn il codice ISBN dell'elemento da rimuovere.
	 */
	void remove(String isbn);

	/**
	 * @return tutti gli elementi in libreria.
	 */
	List<Item> getAll();

	/**
	 * Recupera un elemento.
	 * 
	 * @param isbn il codice ISBN dell'elemento.
	 * @return l'elemento cercato.
	 */

	Optional<Item> getByIsbn(String isbn);

	/**
	 * Recupera un insieme di elementi sulla base dell'anno di pubblicazione.
	 * 
	 * @param fromYear anno da cui iniziare la ricerca (incluso).
	 * @param toYear   anno in cui terminare la ricerca (escluso).
	 * @return l'elenco degli elementi pubblicati negli anni specificati.
	 */
	List<Item> getByYear(int fromYear, int toYear);

	/**
	 * Recupera un insieme di libri scritti da un autore.
	 * 
	 * @param author l'autore da cercare.
	 * @return l'elenco dei libri scritti dall'autore specificato.
	 */
	List<Book> getByAuthor(String author);
}

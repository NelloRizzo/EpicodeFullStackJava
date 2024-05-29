package it.epicode;

public interface Handler<T> {
	/**
	 * Determina il prossimo nodo della catena da invocare una volta terminato il
	 * compito di questo nodo.
	 * 
	 * @param h il prossimo nodo della catena.
	 */
	void setNext(Handler<T> h);

	/**
	 * Gestisce l'input secondo le proprie competenze.
	 * 
	 * @param data input da gestire.
	 */
	void handle(T data);
}

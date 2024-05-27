package it.epicode.blog.businesslayer.services.exceptions;

public class InvalidLoginException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public final String username;
	public final String password;

	public InvalidLoginException(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

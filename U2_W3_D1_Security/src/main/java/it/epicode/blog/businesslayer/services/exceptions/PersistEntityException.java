package it.epicode.blog.businesslayer.services.exceptions;

import it.epicode.blog.businesslayer.services.dto.DtoBase;

public class PersistEntityException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public final DtoBase invalidDto;

	public PersistEntityException(DtoBase invalidDto) {
		this.invalidDto = invalidDto;
	}
}

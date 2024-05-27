package it.epicode.blog.businesslayer.services;

import it.epicode.blog.businesslayer.services.dto.DtoBase;
import it.epicode.blog.datalayer.entities.EntityBase;

public interface Mapper<S extends DtoBase, D extends EntityBase> {

	S convertTo(D input);

	D convertFrom(S input);
}
